package tp4


// sealed trait permet d'interdire d'autres implémentations de Expression (dans d'autres fichiers)
// Du coup il vérifie que le pattern matching est exhaustif dans les match case.

sealed trait Expression
case class IntegerValue(i:Int) extends Expression
case class VariableRef(s:String) extends Expression
case class BinExpression(op:Operator, e1: Expression,e2: Expression) extends Expression

sealed trait Operator
case object Plus extends Operator
case object Minus extends Operator
case object Times extends Operator
case object Inf extends Operator
case object Infeq extends Operator
case object Equal extends Operator

sealed trait Statement
case class Seq(s1:Statement,s2:Statement) extends Statement
case class If(c:Expression,s1:Statement,s2:Statement) extends Statement
case class While(c:Expression,s:Statement) extends Statement
case class Assignement(v:String,e:Expression) extends Statement
case class Print(e:Expression) extends Statement
case class Read(s:String) extends Statement
case object Skip extends Statement

