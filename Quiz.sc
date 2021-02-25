object Quiz {
//InBuilt Method
val o = List(1,2,3,4)                             //> o  : List[Int] = List(1, 2, 3, 4)
o.foldLeft(100)(_-_)                              //> res0: Int = 90
o.foldRight(100)(_+_)                             //> res1: Int = 110
o.scan(0)(_ + _)                                  //> res2: List[Int] = List(0, 1, 3, 6, 10)

//Iterative Type Casted Approach
def foldleft[T](a:List[T],b:T,f:(T,T)=>T):T={
	var acc = b
	var iter = a
	while(!iter.isEmpty){
		acc = f(iter.head,acc)
		iter = iter.tail
	}
	acc
}                                                 //> foldleft: [T](a: List[T], b: T, f: (T, T) => T)T

def foldright[T](a:List[T],b:T,f:(T,T)=>T):T = foldleft(a.reverse,b,f)
                                                  //> foldright: [T](a: List[T], b: T, f: (T, T) => T)T

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
}                                                 //> scan: [T](a: List[T], b: T, f: (T, T) => T)List[T]

foldleft(o,100,(x:Int,y:Int)=>y-x)                //> res3: Int = 90
foldright(o,100,(x:Int,y:Int)=>y+x)               //> res4: Int = 110
scan(o,0,(x:Int,y:Int)=>x+y)                      //> res5: List[Int] = List(0, 1, 3, 6, 10)

}