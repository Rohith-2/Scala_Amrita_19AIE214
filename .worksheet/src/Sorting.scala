object Sorting {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(543); 
 	  def quickSort[T](l0:List[T],asc:Boolean=true)
 	  								(implicit ord : Ordering[T]):List[T] = {
  	if(l0.length < 2) l0
  	else{
  		val p = l0.head
  		val l_lessThanP = quickSort(l0.filter(ord.lt(_ , p)),asc) // or (x => x < p) this is a shorthand
  		val l_greaterThanP = quickSort(l0.filter(ord.gt(_ , p)),asc)
  		val l_equalsP = l0.filter(ord.equiv(_ , p))
  		
  		asc match{
  	 case false =>	l_greaterThanP ++ l_equalsP ++ l_lessThanP
  	 case true =>   l_lessThanP ++ l_equalsP ++ l_greaterThanP
  	}
  	}
  };System.out.println("""quickSort: [T](l0: List[T], asc: Boolean)(implicit ord: Ordering[T])List[T]""");$skip(38); 
  
  val li = List(5,3,4,9,7,1,8,6,2);System.out.println("""li  : List[Int] = """ + $show(li ));$skip(16); val res$0 = 
  quickSort(li);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(53); 
  
  val ls = List("Carrot","Apple","Banana","Kiwi");System.out.println("""ls  : List[String] = """ + $show(ls ));$skip(16); val res$1 = 
  quickSort(ls);System.out.println("""res1: List[String] = """ + $show(res$1));$skip(290); 
  
 	def insertionSort[T](l:List[T],acc:List[T]=Nil)(implicit ord : Ordering[T]) : List[T] = l match {
  		case Nil => acc
  		case x :: ys =>
  			insertionSort ( ys,
  				acc.filter(ord.lt(_, x)) ++
  				( x :: acc.filter(ord.equiv(_,x) ) ++
  				acc.filter(ord.gt(_,x))
  				))
  	};System.out.println("""insertionSort: [T](l: List[T], acc: List[T])(implicit ord: Ordering[T])List[T]""");$skip(19); val res$2 = 
	insertionSort(ls);System.out.println("""res2: List[String] = """ + $show(res$2));$skip(458); 
	
	
	def mergeSort[T](a:List[T])(implicit ord : Ordering[T])={
	def merge (a1:List[T],a2:List[T]):List[T] = (a1,a2) match{
  	case (Nil,_) => a2
  	case (_,Nil) => a1
  	case(x1::y1s,x2::y2s) =>
  		if(ord.lt(x1,x2)) x1 :: merge (y1s,a2)
  		else x2 :: merge (a1,y2s)
  }
  
  def mergesort(a:List[T]):List[T] ={
    val len = a.length/2
    if(len<1) a
    else{
  	val (l,r) = a.splitAt(len)
  	merge(mergesort(l),mergesort(r))
  	}
  }
  mergesort(a)
  };System.out.println("""mergeSort: [T](a: List[T])(implicit ord: Ordering[T])List[T]""");$skip(19); val res$3 = 
  
  mergeSort(ls);System.out.println("""res3: List[String] = """ + $show(res$3))}
}
