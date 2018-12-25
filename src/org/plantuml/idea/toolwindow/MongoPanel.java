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

import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Splitter;
import com.intellij.ui.NumberDocument;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.panels.NonOpaquePanel;
import com.intellij.ui.table.JBTable;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Enumeration;

public class MongoPanel extends JPanel implements Disposable {

    private final Project project;
    private JPanel rootPanel;
    private Splitter splitter;
    private JPanel toolBar;
    private JPanel errorPanel;
    private JPanel paginationPanel;

    private final JTextField rowLimitField = new JTextField();
    private final JBLabel rowCountLabel = new JBLabel();
    private final JBLabel pageNumberLabel = new JBLabel();


    public MongoPanel(Project project) {
        this.project = project;
        this.rootPanel = new JPanel();
        this.setLayout(new BorderLayout());
        TableModel tm = new TableModel() {
            @Override
            public int getRowCount() {
                return 10;
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public String getColumnName(int columnIndex) {
                switch (columnIndex){
                    case 0:
                        return "Key";
                    case 1:
                        return "Value";
                }

                return "not found";
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return "asdas".getClass();
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return "VALUE";
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            }

            @Override
            public void addTableModelListener(TableModelListener l) {

            }

            @Override
            public void removeTableModelListener(TableModelListener l) {

            }
        };

        JBTable table = new JBTable(tm);
        table.setShowColumns(true);
//        table.setFillsViewportHeight(true);
//        table.createDefaultColumnsFromModel();
//        table.updateUI();
//        JBScrollPane jsc = new JBScrollPane();
        table.setVisible(true);
//        jsc.setLayout(new ScrollPaneLayout());
//        jsc.add(table);
//        jsc.setVisible(true);

//        this.rootPanel.add(table);
//        this.splitter = new Splitter();
////        errorPanel.setLayout(new BorderLayout());
//
//
//        splitter.setOrientation(true);
//        splitter.setProportion(0.2f);

//        setLayout(new BorderLayout());
//        setLayout(new BorderLayout());
//        add(jsc, new ScrollPaneLayout());
        add(new JScrollPane(table));

//        initToolBar();
//        initPaginationPanel();

    }


    private void initToolBar() {
        toolBar.setLayout(new BorderLayout());

        JPanel rowLimitPanel = createRowLimitPanel();
        toolBar.add(rowLimitPanel, BorderLayout.WEST);

        JComponent actionToolBarComponent = createResultActionsComponent();
        toolBar.add(actionToolBarComponent, BorderLayout.CENTER);

        JComponent viewToolbarComponent = createSelectViewActionsComponent();
        toolBar.add(viewToolbarComponent, BorderLayout.EAST);
    }

    private void initPaginationPanel() {
        paginationPanel.setLayout(new BorderLayout());

        JComponent actionToolbarComponent = createPaginationActionsComponent();
        paginationPanel.add(actionToolbarComponent, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(pageNumberLabel);
        panel.add(com.intellij.ui.GuiUtils.createVerticalStrut());
        panel.add(rowCountLabel);

        paginationPanel.add(panel, BorderLayout.EAST);
    }

    @NotNull
    private JPanel createRowLimitPanel() {
        rowLimitField.setText("limit");
        rowLimitField.setColumns(5);
        rowLimitField.setDocument(new NumberDocument());
        rowLimitField.setText("Integer.toString(configuration.getDefaultRowLimit())");

        JPanel rowLimitPanel = new NonOpaquePanel();
        rowLimitPanel.add(new JLabel("Row limit:"), BorderLayout.WEST);
        rowLimitPanel.add(rowLimitField, BorderLayout.CENTER);
        rowLimitPanel.add(Box.createHorizontalStrut(5), BorderLayout.EAST);
        return rowLimitPanel;
    }

    @NotNull
    private JComponent createResultActionsComponent() {
        DefaultActionGroup actionResultGroup = new DefaultActionGroup("MongoResultGroup", true);
        actionResultGroup.addSeparator();
        actionResultGroup.addSeparator();

//TODO Duplicate
        ActionToolbar actionToolBar = ActionManager.getInstance().createActionToolbar("MongoResultGroupActions", actionResultGroup, true);
        actionToolBar.setLayoutPolicy(ActionToolbar.AUTO_LAYOUT_POLICY);
        JComponent actionToolBarComponent = actionToolBar.getComponent();
        actionToolBarComponent.setBorder(null);
        actionToolBarComponent.setOpaque(false);
        return actionToolBarComponent;
    }

    @NotNull
    private JComponent createPaginationActionsComponent() {
        DefaultActionGroup actionResultGroup = new DefaultActionGroup("MongoPaginationGroup", false);

//TODO Duplicate
        ActionToolbar actionToolBar = ActionManager.getInstance().createActionToolbar("MongoPaginationGroupActions", actionResultGroup, true);
        actionToolBar.setLayoutPolicy(ActionToolbar.AUTO_LAYOUT_POLICY);
        JComponent actionToolBarComponent = actionToolBar.getComponent();
        actionToolBarComponent.setBorder(null);
        actionToolBarComponent.setOpaque(false);
        return actionToolBarComponent;
    }

    @NotNull
    private JComponent createSelectViewActionsComponent() {
        DefaultActionGroup viewSelectGroup = new DefaultActionGroup("MongoViewSelectGroup", false);

//TODO Duplicate
        ActionToolbar viewToolbar = ActionManager.getInstance().createActionToolbar("MongoViewSelectedActions", viewSelectGroup, true);

        viewToolbar.setLayoutPolicy(ActionToolbar.AUTO_LAYOUT_POLICY);
        JComponent viewToolbarComponent = viewToolbar.getComponent();
        viewToolbarComponent.setBorder(null);
        viewToolbarComponent.setOpaque(false);
        return viewToolbarComponent;
    }


    //TODO refactor
    public void executeQuery() {
    }

    @Override
    public void dispose() {

    }

    //TODO refactor




}
