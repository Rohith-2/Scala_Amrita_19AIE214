object ConSet {

	val set = Empty<--2<--3<--7<--5           //> set  : ConsSet =  2  3  5   7    
  val s = ConsSet()                               //> s  : Empty.type = 
}

abstract class ConsSet {
	def isEmpty:Boolean
	def contains(e:Int):Boolean
	def <-- (e:Int):ConsSet
}

object Empty extends ConsSet{
	def isEmpty = true
	def contains(e:Int) = false
	def <-- (e:Int) = new NonEmpty(e)
	override def toString = ""
}

class NonEmpty(e:Int,left:ConsSet,right:ConsSet) extends ConsSet{
	def this(e:Int) = this (e,Empty,Empty)
	
	def isEmpty = false
	
	def contains(e:Int):Boolean = {
		if (e<this.e) left.contains(e)
		else if (e>this.e) right.contains(e)
		else true
	}
	
	def <-- (e:Int):ConsSet = {
		if (e<this.e) new NonEmpty(this.e,left <-- e,right)
		else if (e>this.e) new NonEmpty(this.e,left,right <-- e)
		else this
	}
	
	override def toString = left.toString + " " + e + " " + right.toString + " "
}

//Unlike the Empty Object, ConsSet Object is a companion hence we dont need to extend
object ConsSet{
	def apply(es:Int*):ConsSet = {
		var s:ConsSet = Empty
		es.foreach(e=>s = s <-- e)
		s
	}
	def apply():Empty.type = Empty
}