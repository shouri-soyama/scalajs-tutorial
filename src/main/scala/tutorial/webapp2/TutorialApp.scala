package tutorial.webapp2

import org.scalajs.dom
import org.scalajs.dom.document
import scala.scalajs.js.JSApp

object TutorialApp extends JSApp {
  def main(): Unit = {
    appendPar(document.body, "Hello World2")
  }
  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }
}
