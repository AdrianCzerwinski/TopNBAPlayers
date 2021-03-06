package com.adrianczerwinski.topnbaplayers.presentation.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adrianczerwinski.topnbaplayers.ui.theme.EXTRA_SMALL_PADDING
import com.adrianczerwinski.topnbaplayers.ui.theme.LightGray
import com.adrianczerwinski.topnbaplayers.ui.theme.StarColor
import com.adrianczerwinski.topnbaplayers.R

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,
    scaleFactor: Float = 3f,
    spaceBetween: Dp = EXTRA_SMALL_PADDING
) {
    val result = calculateStars(rating = rating)


    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        result["filledStars"]?.let {
            repeat(it){
                FilledStar(
                    starPath = starPath,
                    starPathBounds = starPathBounds,
                    scaleFactor = scaleFactor
                )
            }
        }
        result["halfFilledStars"]?.let {
            repeat(it){
                HalfFilledStar(
                    starPath = starPath,
                    starPathBounds = starPathBounds,
                    scaleFactor = scaleFactor
                )
            }
        }
        result["emptyStars"]?.let {
            repeat(it){
                EmptyStar(
                    starPath = starPath,
                    starPathBounds = starPathBounds,
                    scaleFactor = scaleFactor
                )
            }
        }

    }


}

@Composable
fun FilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)
            translate(
                top = top,
                left = left

            ) {
                drawPath(
                    path = starPath,
                    color = StarColor
                )
            }

        }
    }
}

@Composable
fun calculateStars(rating: Double): Map<String, Int>{
    val maxStars by remember { mutableStateOf(5)}
    var filledStars by remember { mutableStateOf(0)}
    var halfFilledStars by remember { mutableStateOf(0)}
    var emptyStars by remember { mutableStateOf(0)}

    LaunchedEffect(key1 = rating){
        val (firstNumber, lastNumber) = rating.toString()
            .split(".")
            .map {it.toInt()}

        if(firstNumber in 0..5 && lastNumber in 0..9){
            filledStars = firstNumber
            if (lastNumber in 1..5) halfFilledStars++
            if (lastNumber in 6..9) filledStars++
            if (firstNumber == 5 && lastNumber > 0) {
                filledStars = 0
                emptyStars = 5
                halfFilledStars = 0
            }
        } else {
            Log.d("RatingWidget", "Invalid rating value")
        }
    }
    emptyStars = maxStars -(filledStars + halfFilledStars)
    return mapOf(
        "filledStars" to filledStars,
        "halfFilledStars" to halfFilledStars,
        "emptyStars" to emptyStars
    )
}

@Composable
fun EmptyStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)
            translate(
                top = top,
                left = left

            ) {
                drawPath(
                    path = starPath,
                    color = LightGray.copy(alpha = 0.5f)
                )
            }

        }
    }
}

@Composable
fun HalfFilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)
            translate(
                top = top,
                left = left

            ) {
                drawPath(
                    path = starPath,
                    color = LightGray.copy(alpha = 0.5f)
                )
                clipPath(path = starPath) {
                    drawRect(
                        color = StarColor,
                        size = Size(
                            height = starPathBounds.maxDimension * scaleFactor,
                            width = starPathBounds.maxDimension/ 1.7f
                        )
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilledStarPreview(

) {
    RatingWidget(modifier = Modifier, rating = 1.0)

}

@Preview(showBackground = true)
@Composable
fun HalfFilledStarPreview(
    scaleFactor: Float = 3f
) {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }
    HalfFilledStar(starPath = starPath, starPathBounds = starPathBounds, scaleFactor = 3f)

}