package cn.kt.chapter1

import java.lang.StringBuilder

open class Tag(val name : String) : Node {

    val children = ArrayList<Node>()
    val properties = mutableMapOf<String, String>()

    operator fun String.invoke(value : String){
        properties[this] = value
    }

    operator fun String.invoke(block : Tag.() -> Unit){
        children.add(Tag(this).apply(block))
    }

    operator fun String.unaryPlus(){
        children.add(StringNode(this@unaryPlus))
    }

    operator fun plus(node : Node){
        children.add(node)
    }

    override fun render(): String {
        return StringBuilder()
            .append("<$name")
            .let {
                if(!properties.isEmpty()){
                    it.append(" ")
                    properties.forEach{ key, value ->
                        it.append(key)
                            .append("=\"")
                            .append(value)
                            .append("\" ")
                    }
                }
                it
            }
            .append(">")
            .let { stringBuilder ->
                children.map { it.render() }.map(stringBuilder::append)
                stringBuilder
            }
            .append("</$name>")
            .toString()
    }
}
