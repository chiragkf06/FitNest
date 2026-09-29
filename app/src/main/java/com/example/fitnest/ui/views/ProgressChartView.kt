package com.example.fitnest.ui.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.fitnest.R

class ProgressChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val dataPoints = floatArrayOf(1800f, 2150f, 1950f, 2400f, 2100f, 2250f, 2050f)
    private val days = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    private val maxVal = 2600f
    private val minVal = 1600f

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 4f
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
        color = ContextCompat.getColor(context, R.color.primary_bright)
    }

    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    private val dotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = ContextCompat.getColor(context, R.color.primary_bright)
    }

    private val dotInnerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.WHITE
    }

    private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 1.5f
        color = ContextCompat.getColor(context, R.color.stroke_subtle)
        pathEffect = DashPathEffect(floatArrayOf(10f, 10f), 0f)
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        textSize = 28f
        color = ContextCompat.getColor(context, R.color.text_secondary)
    }

    private val path = Path()
    private val fillPath = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val density = resources.displayMetrics.density
        linePaint.strokeWidth = 3f * density
        textPaint.textSize = 11f * density

        val leftPadding = 24f * density
        val rightPadding = 24f * density
        val topPadding = 24f * density
        val bottomPadding = 32f * density

        val chartWidth = width - leftPadding - rightPadding
        val chartHeight = height - topPadding - bottomPadding

        if (chartWidth <= 0 || chartHeight <= 0) return

        val stepX = chartWidth / (dataPoints.size - 1)

        // Draw dotted guidelines
        val midY1 = topPadding + chartHeight * 0.33f
        val midY2 = topPadding + chartHeight * 0.66f
        canvas.drawLine(leftPadding, midY1, width - rightPadding, midY1, gridPaint)
        canvas.drawLine(leftPadding, midY2, width - rightPadding, midY2, gridPaint)

        // Calculate points
        val points = mutableListOf<PointF>()
        for (i in dataPoints.indices) {
            val x = leftPadding + i * stepX
            val ratio = (dataPoints[i] - minVal) / (maxVal - minVal)
            val y = topPadding + chartHeight * (1f - ratio.coerceIn(0f, 1f))
            points.add(PointF(x, y))
        }

        // Build smooth curve path
        path.reset()
        fillPath.reset()

        if (points.isNotEmpty()) {
            path.moveTo(points[0].x, points[0].y)
            fillPath.moveTo(points[0].x, points[0].y)

            for (i in 0 until points.size - 1) {
                val p0 = points[i]
                val p1 = points[i + 1]
                val controlX1 = p0.x + (p1.x - p0.x) / 2f
                val controlY1 = p0.y
                val controlX2 = p0.x + (p1.x - p0.x) / 2f
                val controlY2 = p1.y
                path.cubicTo(controlX1, controlY1, controlX2, controlY2, p1.x, p1.y)
                fillPath.cubicTo(controlX1, controlY1, controlX2, controlY2, p1.x, p1.y)
            }

            // Fill gradient below curve
            fillPath.lineTo(points.last().x, topPadding + chartHeight)
            fillPath.lineTo(points.first().x, topPadding + chartHeight)
            fillPath.close()

            val primaryColor = ContextCompat.getColor(context, R.color.primary_bright)
            fillPaint.shader = LinearGradient(
                0f, topPadding,
                0f, topPadding + chartHeight,
                Color.argb(70, Color.red(primaryColor), Color.green(primaryColor), Color.blue(primaryColor)),
                Color.argb(0, Color.red(primaryColor), Color.green(primaryColor), Color.blue(primaryColor)),
                Shader.TileMode.CLAMP
            )
            canvas.drawPath(fillPath, fillPaint)

            // Draw line
            canvas.drawPath(path, linePaint)

            // Draw points and labels
            for (i in points.indices) {
                val pt = points[i]
                // Outer circle
                canvas.drawCircle(pt.x, pt.y, 5f * density, dotPaint)
                // Inner white center
                canvas.drawCircle(pt.x, pt.y, 2.5f * density, dotInnerPaint)

                // Day text
                val labelY = height - 8f * density
                canvas.drawText(days[i], pt.x, labelY, textPaint)
            }
        }
    }
}
