package tp4

import tp4.PrettyPrinter.{ stringOf}



object Main {
  def main(args : Array[String]) : Unit = {
		val exp=BinExpression(Plus,VariableRef("y"),BinExpression(Minus,IntegerValue(1),IntegerValue(2)))
		val prog=Seq(Assignement("x",IntegerValue(0)),
			Seq(Assignement("y",IntegerValue(1)),
				Seq(Read("z"),
					Seq(While(BinExpression(Inf,VariableRef("x"),VariableRef("z")),
						Seq(Assignement("x",BinExpression(Plus,VariableRef("x"),IntegerValue(1))),
							Seq(Assignement("y",BinExpression(Times,VariableRef("y"),VariableRef("x"))),
								Print(VariableRef("x"))))),
						Print(VariableRef("y"))))))

		// A compléter
		println(stringOf(prog))
		//val e = BinExpression(Plus, IntegerValue(2), IntegerValue(9))
	//	println(stringOf(exp))
  }
}


