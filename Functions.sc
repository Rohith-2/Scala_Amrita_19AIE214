object Functions {
val i1 = 10                                       //> i1  : Int = 10

// Functions are first class citizens ...
/*
	Functions can do anything data (variable) can do ..
	1. Passes as arguments
	2. Return as result
	3. Store in other variables
	4. Make Object
	5. can have literals / constants
*/

// Vals and Vars have a memory location storing their data
// This memory gives these entities an 'L-Value'
// "L-Value" refers to the left hand side i.e. the memory location

def fn0 = 5 + 5  // def fn0 = {5 + 5}             //> fn0: => Int
val i2 = fn0                                      //> i2  : Int = 10

//What is a function?
/*
	Function is a mapping
	It maps from a set of values called the 'Domain' to a set of values called 'Range'
	example : 1.5! doesnt exist it domain is natural numbers only. (Euler's gamma is used for 1.5!)
	
	Function is an uncomputed expression (raw)
	Functions have no 'L-value' like in a variable but have a different version of it
	
	Inference works by finite substitution (type) - Lykov's substitution Principle
	
	i2?
	context fn0
	fn0?
	Int + Int ==> Int
	fn0 is Int
	therefore , i2 will also be Int
	
	Whats the Domain for fn0?
	NULL Set ==> Integers
*/

// First instance of 'no inference'
// The formal parameter 'x' cannot be inferred
// Why? Because its a no context

def fn1(x:Int) : Int = x + x                      //> fn1: (x: Int)Int
// if it was def fn1(x:Int) = x + 3.5f         the output will be
fn1(5)                                            //> res0: Int = 10

//Multiple Arguments
def fn2 (x:Int ,y:Float) = x+y                    //> fn2: (x: Int, y: Float)Float
fn2(1,4.5f)                                       //> res1: Float = 5.5

//Multiline Function
//Can i change the formal arguments for x and y?
//No idiot you can't, all formal parameters are vals and hence immutable, it means dummy
//the x and y you gove in fn0 cant be modified

// Also idiot all the def put equal to becuase scala will accept
/*
def fn3(x:Int, y:Float)  {
.....
}
but the return type is unit no matter what you return
*/

def fn3(x:Int, y:Float) = {
	x+y
}                                                 //> fn3: (x: Int, y: Float)Float

//Nested Functions
def fn4(x:Array[Int],scale:Int) = {
	def inner(n:Int) = {
	
		var nx:List[Int] = List();
		var i = x.length

		while(i>0){
			nx = x(i-1)*n :: nx
			i-=1
	}
	nx
}
inner(scale).toArray
//The last line in the functions body block becomes the return type
}                                                 //> fn4: (x: Array[Int], scale: Int)Array[Int]
/*
	Steps in the above iteration
	l1 (Nil)
	l2 (49,l1)
	l3 (42,l2)
	l4 (35,l3)
	l5 (28,l4)
	
*/

fn4(Array(4,5,6,7),7)                             //> res2: Array[Int] = Array(28, 35, 42, 49)


}