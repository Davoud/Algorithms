package percolation

class Percolation(private val n: Int) {

    val grid: Array[Array[Boolean]] = Array.fill[Boolean](n, n) { false }
    var numOpenSites : Int = 0
    val connManager = new ConnectionManager(n, n, isOpen)
   
    def open(row: Int, col:Int): Unit = {
        if(isOpen(row, col)) return
        grid(row)(col) = true
        numOpenSites += 1
        connManager.open(row, col)
    }

    def isOpen(row: Int, col: Int) : Boolean = {
        validateRange(row, col)
        grid(row)(col)
    }
    
    def numberOfOpenSites() : Int = numOpenSites

    def isFull(row: Int, col: Int) : Boolean = connManager.isFull(row, col)

    def percolates(): Boolean = connManager.percolates()

    private def validateRange(row: Int, col: Int): Unit = {
        if (!(0 <= row && row < n && 0 <= col && col < n)) {
            throw new IndexOutOfBoundsException("row/col index out of range")
        }
    }
}