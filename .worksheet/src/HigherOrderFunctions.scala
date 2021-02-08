object HigherOrderFunctions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to HoF");$skip(138); 
  
  def sumInts(x:Int, y:Int) = {
  
  	def iter(x:Int,acc:Int):Int={
  		if(x>y)acc;
  		else iter(x+1,acc+x)
  	}
  	
  	iter(x,0)
  };System.out.println("""sumInts: (x: Int, y: Int)Int""");$skip(19); val res$0 = 
  
  sumInts(1,10);System.out.println("""res0: Int = """ + $show(res$0));$skip(142); 
  
  def sumSqInts(x:Int, y:Int) = {
  
  	def iter(x:Int,acc:Int):Int={
  		if(x>y)acc;
  		else iter(x+1,acc+x*x)
  	}
  	
  	iter(x,0)
  };System.out.println("""sumSqInts: (x: Int, y: Int)Int""");$skip(21); val res$1 = 
  
  sumSqInts(1,10);System.out.println("""res1: Int = """ + $show(res$1));$skip(220); 
  
  /*
  	HigherOrderFunction :
  	Generalises the series summation
  */
   def sum(f:Int=>Int,x:Int, y:Int) = {
  
  	def iter(x:Int,acc:Int):Int={
  		if(x>y)acc;
  		else iter(x+1,acc+f(x))
  	}
  	
  	iter(x,0)
  };System.out.println("""sum: (f: Int => Int, x: Int, y: Int)Int""");$skip(20); val res$2 = 
  
  sum(x=>x,1,10);System.out.println("""res2: Int = """ + $show(res$2));$skip(19); val res$3 = 
  sum(x=>x*x,1,10);System.out.println("""res3: Int = """ + $show(res$3));$skip(21); val res$4 = 
  sum(x=>x*x*x,1,10);System.out.println("""res4: Int = """ + $show(res$4));$skip(310); 
  
  //We want to generalise all series operations
  def mapreduce(x:Int,y:Int,
  					map : Int=>Int = x=>x,
  					reduce:(Int,Int)=>Int = (a,b)=>a+b,
  					iden: Int = 0
  					) = {
  					
  	def iter(x:Int,acc:Int):Int={
  		if(x>y)acc;
  		else iter(x+1,reduce(acc,map(x)))
  	}
  	
  	iter(x,iden)
 };System.out.println("""mapreduce: (x: Int, y: Int, map: Int => Int, reduce: (Int, Int) => Int, iden: Int)Int""");$skip(281); 
 
   def mapreduce1
  					(
  					map : Int=>Int = x=>x,
  					reduce:(Int,Int)=>Int = (a,b)=>a+b,
  					iden: Int = 0
  					)
  					(x:Int)(y:Int) = {
  					
  	def iter(x:Int,acc:Int):Int={
  		if(x>y)acc;
  		else iter(x+1,reduce(acc,map(x)))
  	}
  	
  	iter(x,iden)
 };System.out.println("""mapreduce1: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int)(x: Int)(y: Int)Int""");$skip(44); val res$5 = 
 
 		//HoF for summation
  	mapreduce(1,10);System.out.println("""res5: Int = """ + $show(res$5));$skip(26); val res$6 = 
  	mapreduce(1,10,x=>x*x);System.out.println("""res6: Int = """ + $show(res$6));$skip(66); val res$7 = 
  	
  	//factorial example
  	mapreduce1(x=>x,(u,v)=>u*v,1)(1)(5);System.out.println("""res7: Int = """ + $show(res$7));$skip(72); 
  	
  	//Partially Applied
  	val prod = mapreduce1(x=>x,(u,v)=>u*v,1)_;System.out.println("""prod  : Int => (Int => Int) = """ + $show(prod ));$skip(14); val res$8 = 
  	prod(1)(5);System.out.println("""res8: Int = """ + $show(res$8));$skip(107); 
  	
  	//factorial using partially applied general function
  	val fct = mapreduce1(x=>x,(u,v)=>u*v,1)(1)_;System.out.println("""fct  : Int => Int = """ + $show(fct ))}
}
