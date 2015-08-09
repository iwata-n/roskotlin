package iwatan.kotlin.sample


import org.ros.message.MessageListener
import org.ros.namespace.GraphName
import org.ros.node.AbstractNodeMain
import org.ros.node.ConnectedNode
import org.ros.node.NodeMain
import org.ros.node.topic.Subscriber

public class Listener() : AbstractNodeMain() {

    override
    public fun getDefaultNodeName(): GraphName {
        return GraphName.of("roskotlin/listener")
    }

    override
    public fun onStart(connectedNode: ConnectedNode) {
        val log = connectedNode.getLog()
        val subscriber = connectedNode.newSubscriber<std_msgs.String>("chatter", std_msgs.String._TYPE)
        subscriber.addMessageListener { message ->
            log.info("Kotlin heard: \"" + message.getData() + "\"")
        }
    }
}