/*
 * Ext JS Library 2.2.1
 * Copyright(c) 2006-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

/**
 * @class Ext.ux.XmlTreeLoader
 * @extends Ext.tree.TreeLoader
 * <p>A TreeLoader that can convert an XML document into a hierarchy of {@link Ext.tree.TreeNode}s.
 * Any text value included as a text node in the XML will be added to the parent node as an attribute
 * called <tt>innerText</tt>.  Also, the tag name of each XML node will be added to the tree node as
 * an attribute called <tt>tagName</tt>.</p>
 * <p>By default, this class expects that your source XML will provide the necessary attributes on each 
 * node as expected by the {@link Ext.tree.TreePanel} to display and load properly.  However, you can
 * provide your own custom processing of node attributes by overriding the {@link #processNode} method
 * and modifying the attributes as needed before they are used to create the associated TreeNode.</p>
 * @constructor
 * Creates a new XmlTreeloader.
 * @param {Object} config A config object containing config properties.
 */
Ext.ux.XmlTreeLoader = Ext.extend(Ext.tree.TreeLoader, {
    /**
     * @property  XML_NODE_ELEMENT
     * XML element node (value 1, read-only)
     * @type Number
     */
    XML_NODE_ELEMENT : 1,
    /**
     * @property  XML_NODE_TEXT
     * XML text node (value 3, read-only)
     * @type Number
     */
    XML_NODE_TEXT : 3,
    
    // private override
    processResponse : function(response, node, callback){
        var xmlData = response.responseXML;
        var root = xmlData.documentElement || xmlData;
        
        try{
            node.beginUpdate();
            node.appendChild(this.parseXml(root));
            node.endUpdate();
            
            if(typeof callback == "function"){
                callback(this, node);
            }
        }catch(e){
            this.handleFailure(response);
        }
    },
    
    // private
    parseXml : function(node) {
        var nodes = [];
        Ext.each(node.childNodes, function(n){
            if(n.nodeType == this.XML_NODE_ELEMENT){
                var treeNode = this.createNode(n);
                if(n.childNodes.length > 0){
                    var child = this.parseXml(n);
                    if(typeof child == 'string'){
                       treeNode.attributes.innerText = child;
					            // aiming add child node
					            var childNode = new Ext.tree.AsyncTreeNode({
					                text: child, 
					                draggable:true,
					                loaded:true,
					                leaf:true					                
					            }); 
					            treeNode.appendChild(childNode);                      
                    }else{
                        treeNode.appendChild(child);
                    }
                }
                //aiming add            
                treeNode.loaded=true;
                nodes.push(treeNode);
            }
            else if(n.nodeType == this.XML_NODE_TEXT){
                var text = n.nodeValue.trim();
                if(text.length > 0){
                    return nodes = text;
                }
            }
        }, this);
        
        return nodes;
    },
    
    // private override
    createNode : function(node){
        var attr = {
            tagName: node.tagName           
        };
        
        Ext.each(node.attributes, function(a){
            attr[a.nodeName] = a.nodeValue;
        });
        
        this.processAttributes(attr,node);
        return Ext.ux.XmlTreeLoader.superclass.createNode.call(this, attr);
    },
    
    /*
     * Template method intended to be overridden by subclasses that need to provide
     * custom attribute processing prior to the creation of each TreeNode.  This method
     * will be passed a config object containing existing TreeNode attribute name/value
     * pairs which can be modified as needed directly (no need to return the object).
     */
    processAttributes: Ext.emptyFn
    
});



/**
 *  DWRTreeLoader
 */
Ext.tree.DWRTreeLoader = function(config) {

  Ext.tree.DWRTreeLoader.superclass.constructor.call(this, config);

};



Ext.extend(Ext.tree.DWRTreeLoader, Ext.tree.TreeLoader, {

   requestData : function(node, callback) {

    if (this.fireEvent("beforeload", this, node, callback) !== false) {



      //todo

      //var params = this.getParams(node);



      var callParams = new Array();

      var success = this.handleResponse.createDelegate(this, [node, callback], 1);

      var error = this.handleFailure.createDelegate(this, [node, callback], 1);

      callParams.push(node.id);

      callParams.push({callback:success, errorHandler:error});



      //todo: do we need to set this to something else?

      this.transId=true;

      this.dataUrl.apply(this, callParams);

    } else {

      // if the load is cancelled, make sure we notify

      // the node that we are done

      if (typeof callback == "function") {

        alert(callback);

        callback();

      }

    }

  },

    processResponse : function(response, node, callback){

        try {

          for(var i = 0; i < response.length; i++){

                var n = this.createNode(response[i]);

                if(n){

                    node.appendChild(n);

                }

            }

            if(typeof callback == "function"){

                callback(this, node);

            }

        }catch(e){

            this.handleFailure(response);

        }

    },



    handleResponse : function(response, node, callback){

        this.transId = false;

        this.processResponse(response, node, callback);

        this.fireEvent("load", this, node, response);

    },



    handleFailure : function(response, node, callback){

        this.transId = false;

        this.fireEvent("loadexception", this, node, response);

        if(typeof callback == "function"){

            callback(this, node);

        }

    }


}); 



