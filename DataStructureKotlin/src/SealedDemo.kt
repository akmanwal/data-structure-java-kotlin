fun main() {
    val result = getArea(Shape.Square(4, 5))
    print(result)
}

sealed class Shape {
    class Rectangle(val width: Int, val height: Int) : Shape()
    class Square(val width: Int, val height: Int) : Shape()
}

fun getArea(shape: Shape): Int {
    return when (shape) {
        is Shape.Rectangle -> shape.width * shape.height
        is Shape.Square -> shape.width * shape.height
        else -> {0}
    }
}