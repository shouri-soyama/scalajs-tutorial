package tutorial.webapp

import org.scalajs.dom
import org.scalajs.jquery.jQuery
import dom.document
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.JSApp

object TutorialApp extends JSApp {
  def main(): Unit = {
    appendPar(document.body, "Hello World")
    js.eval("Array.prototype.fuga = function() { console.log(this) }")
    js.Dynamic.global.hoge = "test"
    js.Dynamic.global.$("#click-me-button").on("click", addClickedMessage _)
//    js.Dynamic.global.addClick = addClickedMessage _
//    js.Dynamic.global.Array.prototype.addClick = addClickedMessage _
    
  }
  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }
  def addClickedMessage(e: js.Any): Unit = {
    js.Dynamic.global.console.dir(e)
    val mydata = js.Dynamic.global.mydata
    js.Dynamic.global.console.log("aaaaaaa")
    appendPar(document.body, mydata.msg.asInstanceOf[String])
  }
}
