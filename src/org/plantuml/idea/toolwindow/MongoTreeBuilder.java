/*
 * Copyright (c) 2018 David Boissier.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.plantuml.idea.toolwindow;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeBuilder;
import com.intellij.ide.util.treeView.AbstractTreeStructure;
import com.intellij.ide.util.treeView.NodeDescriptor;
import com.intellij.ide.util.treeView.PresentableNodeDescriptor;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.Arrays;

class MongoServer {

}
class MongoDatabase {

}
class MongoCollection {

}
public class MongoTreeBuilder extends AbstractTreeBuilder {


//    private static final Icon MONGO_SERVER = GuiUtils.loadIcon("mongo_logo.png");
//    private static final Icon MONGO_DATABASE = GuiUtils.loadIcon("database.png");
//    private static final Icon MONGO_COLLECTION = GuiUtils.loadIcon("folder.png");
//    private static final Icon MONGO_SERVER_ERROR = GuiUtils.loadIcon("mongo_warning.png");

//    private final Map<MongoServer, ServerConfiguration> serverConfigurations = new HashMap<>();

    private static final RootDescriptor ROOT_DESCRIPTOR = new RootDescriptor();

    public MongoTreeBuilder(@NotNull Tree tree) {
        init(tree, new DefaultTreeModel(new DefaultMutableTreeNode()), new MyTreeStructure(), (descriptorLeft, descriptorRight) -> {
//            if (descriptorLeft instanceof ServerDescriptor && descriptorRight instanceof ServerDescriptor) {
//                MongoServer mongoServerLeft = (MongoServer) descriptorLeft.getElement();
//                MongoServer mongoServerRight = (MongoServer) descriptorRight.getElement();
//
//                return mongoServerLeft.getLabel().compareTo(mongoServerRight.getLabel());
//            } else if (descriptorLeft instanceof DatabaseDescriptor && descriptorRight instanceof DatabaseDescriptor) {
//                String databaseDescriptorLeft = ((DatabaseDescriptor) descriptorLeft).getElement().getName();
//                String databaseDescriptorRight = ((DatabaseDescriptor) descriptorRight).getElement().getName();
//
//                return databaseDescriptorLeft.compareTo(databaseDescriptorRight);
//            } else if (descriptorLeft instanceof CollectionDescriptor && descriptorRight instanceof CollectionDescriptor) {
//                String collectionDescriptorLeft = ((CollectionDescriptor) descriptorLeft).getElement().getName();
//                String collectionDescriptorRight = ((CollectionDescriptor) descriptorRight).getElement().getName();
//
//                return collectionDescriptorLeft.compareTo(collectionDescriptorRight);
//            }
            return 0;
        }, true);
        initRootNode();
    }

//    public MongoServer addConfiguration(@NotNull ServerConfiguration serverConfiguration) {
//        MongoServer mongoServer = new MongoServer(serverConfiguration);
//        serverConfigurations.put(mongoServer, serverConfiguration);
//        queueUpdateFrom(RootDescriptor.ROOT, true);
//        return mongoServer;
//    }

    public void removeConfiguration(MongoServer mongoServer) {
//        serverConfigurations.remove(mongoServer);
        queueUpdateFrom(RootDescriptor.ROOT, true);
    }

    public void removeDatabase(MongoDatabase mongoDatabase) {
//        MongoServer parentServer = mongoDatabase.getParentServer();
//        parentServer.getDatabases().remove(mongoDatabase);
//        queueUpdateFrom(parentServer, true);
    }

    public void removeCollection(MongoCollection mongoCollection) {
//        MongoDatabase parentDatabase = mongoCollection.getParentDatabase();
//        parentDatabase.getCollections().remove(mongoCollection);
//        queueUpdateFrom(parentDatabase, true);
    }

    public void expandAll() {
        Arrays.stream(getTreeStructure().getChildElements(RootDescriptor.ROOT))
                .forEach((server) -> this.expand(server, null));
    }

    public void collapseAll() {
        Arrays.stream(getTreeStructure().getChildElements(RootDescriptor.ROOT))
                .forEach((server) -> this.collapseChildren(server, null));
    }

    private class MyTreeStructure extends AbstractTreeStructure {
        @Override
        public Object getRootElement() {
            return RootDescriptor.ROOT;
        }

        @Override
        public Object[] getChildElements(Object element) {
//            if (element == RootDescriptor.ROOT) {
//                return ArrayUtil.toObjectArray(serverConfigurations.keySet());
//            } else if (element instanceof MongoServer) {
//                return ArrayUtil.toObjectArray(((MongoServer) element).getDatabases());
//            } else if (element instanceof MongoDatabase) {
//                return ArrayUtil.toObjectArray(((MongoDatabase) element).getCollections());
//            }
            String[] toppings = new String[2];
            toppings[0] = "TEST";
//            return ArrayUtil.toObjectArray(toppings);
            return toppings;
        }

        @Nullable
        @Override
        public Object getParentElement(Object element) {
//            if (element == RootDescriptor.ROOT) {
//                return null;
//            } else if (element instanceof MongoServer) {
//                return RootDescriptor.ROOT;
//            } else if (element instanceof MongoDatabase) {
//                return ((MongoDatabase) element).getParentServer();
//            } else if (element instanceof MongoCollection) {
//                return ((MongoCollection) element).getParentDatabase();
//            } else {
            return null;
//            }
        }

        @NotNull
        @Override
        public NodeDescriptor createDescriptor(Object element, NodeDescriptor parentDescriptor) {
              return ROOT_DESCRIPTOR;
        }


        @Override
        public void commit() {
            // do nothing
        }

        @Override
        public boolean hasSomethingToCommit() {
            return false;
        }
    }

    private static abstract class MyNodeDescriptor<T> extends PresentableNodeDescriptor<T> {
        private final T myObject;

        MyNodeDescriptor(@Nullable NodeDescriptor parentDescriptor, @NotNull T object) {
            super(null, parentDescriptor);
            myObject = object;
        }

        @Override
        public T getElement() {
            return myObject;
        }
    }

    private static class RootDescriptor extends MyNodeDescriptor<Object> {
        static final Object ROOT = new Object();

        private RootDescriptor() {
            super(null, ROOT);
        }

        @Override
        protected void update(PresentationData presentation) {
            presentation.addText("<root 123>", SimpleTextAttributes.REGULAR_ATTRIBUTES);
        }
    }


    static class DatabaseDescriptor extends MyNodeDescriptor<MongoDatabase> {
        DatabaseDescriptor(NodeDescriptor parentDescriptor, MongoDatabase database) {
            super(parentDescriptor, database);
        }

        @Override
        protected void update(PresentationData presentation) {
//            presentation.setIcon(MONGO_DATABASE);
            presentation.addText("asdasdas", SimpleTextAttributes.REGULAR_ATTRIBUTES);
        }
    }

    static class CollectionDescriptor extends MyNodeDescriptor<MongoCollection> {
        CollectionDescriptor(NodeDescriptor parentDescriptor, MongoCollection collection) {
            super(parentDescriptor, collection);
        }

        @Override
        protected void update(PresentationData presentation) {
//            presentation.setIcon(MONGO_COLLECTION);
            presentation.addText("123123123", SimpleTextAttributes.REGULAR_ATTRIBUTES);
        }
    }
}
