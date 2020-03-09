
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rishabh Karnwal
 */
public class JcheckBoxList extends JFrame {
    public ArrayList<Integer> selectedCol ;
    public JCheckBox[] jb;
    public JButton btn_ok;
    public int n;
    public JcheckBoxList(ArrayList<String> list)
    {
        setLayout(new FlowLayout());
//        JLabel l = new JLabel("Columns");
//        add(l);
        /*ArrayList<String> list = new ArrayList<>();
        list.add("first");
        list.add("second 2");*/
        n = list.size();
        jb = new JCheckBox[n];
        for(int i = 0; i < n; i++)
        {
            jb[i]= new JCheckBox(list.get(i));
            add(jb[i]);
        }
        btn_ok = new JButton("OK");
        add(btn_ok);
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        setSize(100,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public ArrayList<Integer> getAllSelected()
    {
        selectedCol = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            if(jb[i].isSelected())
            {
                selectedCol.add(i);
            }
        }
        return selectedCol;
    }
    
    public void btn_okActionPerformed(ActionEvent ae)
    {
        SQL_DB_UI.selectedCol.clear();
        for(int i = 0; i < n; i++)
        {
            if(jb[i].isSelected())
            {
                SQL_DB_UI.selectedCol.add(i);
            }
        }
        this.dispose();
    }
    
}
