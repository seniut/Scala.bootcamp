import scala.collection.mutable.ListBuffer
object Main {
  def main(args: Array[String]): Unit = {
    println("Poker Hand Evaluator")
    println("=======================================")
    println("")
    println("Instructions:")
    println(" - Enter card on bord and hands in the following format:")
    println("     <5 board cards> <hand 1> <hand 2> <...> <hand N>")
    println("     <hand x> is 2 or 4 cards")
    println("     <card> is a 2 character string with the first character representing the Values and the second character representing the Suits")
    println("     Suits: C=Clubs, H=Hearts, S=Spades, D=Diamonds")
    println("     Values: 2,3,4,5,6,7,8,9,T,J,Q,K,A")
    println(" - Example:")
    println("     4cKs4h8s7s Ad4s Ac4d As9s KhKd 5d6d")
    println(" - OR:")
    println("     4cKs4h8s7s Ad4sTd2s Ac4d5c6c As9s7d8d KhKdAsTs 5d6d9c8c")
    println("")
    println("")


    val a: String = System.console().readLine("Enter <5 board cards> <hand 1> <...> <hand N> where <hand x> is 2 or 4 cards: ")

    println("Input is:")
    println(a)

    var list_1 = new ListBuffer[String]()
    var list_2 = new ListBuffer[String]()
    a.split(" ").toList.foreach(e => if (e.length() == 10) list_1 += e else if (e.length() == 4 || e.length() == 8) list_2 += e)

    while ( list_1.isEmpty || list_2.isEmpty || list_1.toList.toSet.size != list_1.toList.size || list_2.toList.toSet.size != list_2.toList.size ){
      val a: String = System.console().readLine("Incorrect <5 board cards> or <hand x>. Enter <5 board cards> <hand 1> <...> <hand N> where <hand x> is 2 or 4 cards: ")
      a.split(" ").toList.foreach(e => if (e.length() == 10) list_1 += e else if (e.length() == 4 || e.length() == 8) list_2 += e)
    }

    val l_1 = list_2.toList.collect {case t => t.grouped(2).toList}
    val l_2 = list_1.mkString(" ").grouped(2).toList

    val gen = l_1.collect {case t => (t.mkString(""),gen_hand(t, l_2))}

    val res = for {i <- gen.map(e => (e._1,e._2.asInstanceOf[Vector[List[String]]]))
                   a <- i._2} yield (i._1,a.asInstanceOf[List[String]])

    val h = for {e <- res} yield (e._1,Hand(e._2).eval(Hand(e._2)))

    val hd = for {i <- h} yield (i._1, i._2._1, i._2._2, if (i._2._3.take(2).mkString.length == 2) i._2._3.take(2).mkString.concat("0").toInt else i._2._3.take(2).mkString.toInt)
    val sh = hd.groupBy(_._1).mapValues(_.map(_._4).max).toList
    println("Output is:")
    val r = for (a <- sh.sortBy(_._2)) yield a._1
    println(r.mkString(", "))

//    for {(left,right) <- sh zip sh.tail} if (left._2 == right._2) print(left._1 + "=" + right._1)
    //    val r = for {(left,right) <- sh zip sh.tail} yield (left,right) match {
    //                                                                            case left._2 == right._2 => sh.filter(_._1 != left._1).filter(_._1 != right._1)
    //
    //                                                                          }

  }

  def gen_hand(l_1: List[String], l_2: List[String]): Object = {
    val cl = 5
    Range(1,cl).flatMap{
      x => for {
        ls <- l_1.combinations(x)    if l_1.length >= x
        ns <- l_2.combinations(cl-x) if l_2.length >= cl-x
      } yield ls ++ ns
    }
  }
}
