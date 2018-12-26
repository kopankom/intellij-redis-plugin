package org.kopankom.Redis;

import com.intellij.openapi.Disposable;
import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;

public class DataExplorerPanel extends JPanel implements Disposable {

    public DataExplorerPanel() {
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
        table.setVisible(true);
        add(new JScrollPane(table));
    }

    @Override
    public void dispose() {

    }

}
