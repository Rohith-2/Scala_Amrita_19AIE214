object Fold {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(53); 

//InBuilt Method
val o = List(1,2,3,4);System.out.println("""o  : List[Int] = """ + $show(o ));$skip(21); val res$0 = 
o.foldLeft(100)(_-_);System.out.println("""res0: Int = """ + $show(res$0));$skip(22); val res$1 = 
o.foldRight(100)(_+_);System.out.println("""res1: Int = """ + $show(res$1));$skip(17); val res$2 = 
o.scan(0)(_ + _);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(184); 

//Iterative Type Casted Approach
def foldleft[T](a:List[T],b:T,f:(T,T)=>T):T={
	var acc = b
	var iter = a
	while(!iter.isEmpty){
		acc = f(iter.head,acc)
		iter = iter.tail
	}
	acc
};System.out.println("""foldleft: [T](a: List[T], b: T, f: (T, T) => T)T""");$skip(72); 

def foldright[T](a:List[T],b:T,f:(T,T)=>T):T = foldleft(a.reverse,b,f);System.out.println("""foldright: [T](a: List[T], b: T, f: (T, T) => T)T""");$skip(172); 

def scan[T](a:List[T],b:T,f:(T,T)=>T)={
	var r = List(b)
	var acc = b
	var iter = a
	while(!iter.isEmpty){
		acc = f(acc,iter.head)
		r :+= acc
		iter = iter.tail
	}
	r
};System.out.println("""scan: [T](a: List[T], b: T, f: (T, T) => T)List[T]""");$skip(36); val res$3 = 

foldleft(o,100,(x:Int,y:Int)=>y-x);System.out.println("""res3: Int = """ + $show(res$3));$skip(36); val res$4 = 
foldright(o,100,(x:Int,y:Int)=>y+x);System.out.println("""res4: Int = """ + $show(res$4));$skip(29); val res$5 = 
scan(o,0,(x:Int,y:Int)=>x+y);System.out.println("""res5: List[Int] = """ + $show(res$5))}

}
