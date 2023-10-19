package tp4

object PrettyPrinter {
  def stringOfOp(op: Operator):String =
    op match {
      case Plus => " + "
      case Minus => " - "
      case Times => " * "
      case Inf =>  " < "
      case Infeq => " <= "
      case Equal => " = "
  }


  def stringOfExp(e:Expression):String = {
    e match {
      case IntegerValue(i) => i.toString
      case VariableRef(v) => v
      case BinExpression(op, e1, e2) => {
        "("+ stringOfExp(e1) + stringOfOp(op) + stringOfExp(e2) +")"
      }

    }
  }
    def stringOfStatement(s:Statement, p:Int):String={
       s match {
         case Seq(s1, s2) =>{
           indentation(p) + stringOfStatement(s1,p)+ "\n" +stringOfStatement(s2,p)
         }
         case If(c, s1, s2) =>{
           indentation(p) + "If ( "+stringOfStatement(s1,p+1)+stringOfExp(c)+stringOfStatement(s2,p+1)+" )"
         }
         case While(c, s) => {
           indentation(p) + "while ("+stringOfExp(c)+") do\n{"  +  "\n"+stringOfStatement(s,p+1)+"\n}"
         }
         case Assignement(v, e) => {
           indentation(p) + v + " := " +stringOfExp(e)
         }
         case Print(e) => indentation(p) + "print ("+stringOfExp(e)+")"
         case Read(s) => indentation(p) + "read ("+ s +")"
         case skip => "\n"
       }
    }

  private def indentation(p:Int):String = {
    p match {
      case 0 => ""
      case _ => " " + indentation(p-1)
    }
  }

   def stringOf(p: Statement): String = stringOfStatement(p, 0)



}
