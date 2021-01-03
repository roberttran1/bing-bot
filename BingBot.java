package BingBotGUI;

import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robert
 */
public class BingBot extends javax.swing.JFrame {
    private int count;
    private Timer timer;
    private boolean running;
    private TimerTask task;
    private String[] words;
    
    /**
     * Creates new form BingBotGUI
     */
    public BingBot() {
        initComponents();
        running = false;
        /*
        words = new String[]{"South Creek","Roslyn","Sprague","Gig Harbor","Lake Cassidy",
        "Tenino","Jamestown","Three Lakes","Curlew Lake","Chain Lake","Pateros",
        "Rosburg","Parkland","Birch Bay","Ashford","Navy Yard City","Omak",
        "Farmington","Buckley","Cathcart","Poulsbo","Anacortes","Maplewood",
        "Creston","Rockford","Wishram","Centralia","South Hill","Longview Heights",
        "Erlands Point-Kitsap Lake","Amboy","St. John","Dallesport","Ketron Island",
        "Mesa","Fife","Moses Lake North","Chewelah","Grayland","Kittitas","Camano",
        "Monroe North","North Bonneville","Klickitat","Loon Lake","Newport","Mead",
        "Cashmere","Aberdeen Gardens","Ocean Shores","Basin City","Wilkeson","Meadow Glade",
        "Arlington Heights","Uniontown","Oakesdale","West Side Highway","Conconully","Latah",
        "Elma","Tieton","Southworth","Danville","Toppenish","River Road","Geneva","Yakima","Moxee",
        "Edmonds","Kalama","Laurier","Vashon","Country Homes","Darrington","Metaline Falls","Lyle",
        "Cascade Valley","Spangle","Methow","Waterville","Lake Roesiger","Milton","Krupp","Alderton", 
        "Marilyn Monroe","Abraham Lincoln","Mother Teresa","John F. Kennedy","Martin Luther King",
        "Nelson Mandela","Winston Churchill","Bill Gates","Muhammad Ali","Mahatma Gandhi",
        "Margaret Thatcher","Charles de Gaulle","Christopher Columbus","George Orwell",
        "Charles Darwin","Elvis Presley","Albert Einstein","Paul McCartney","Plato",
        "Queen Elizabeth II","Queen Victoria","John M Keynes","Mikhail Gorbachev",
        "Jawaharlal Nehru","Leonardo da Vinci","Louis Pasteur","Leo Tolstoy","Pablo Picasso",
        "Vincent Van Gogh","Franklin D. Roosevelt","Pope John Paul II","Thomas Edison",
        "Rosa Parks","Aung San Suu Kyi","Lyndon Johnson","Ludwig Beethoven","Oprah Winfrey",
        "Indira Gandhi","Eva Peron","Benazir Bhutto","Desmond Tutu","Dalai Lama","Walt Disney",
        "Neil Armstrong","Peter Sellers"};
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numSearches = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Bing Bot 2.0");

        jLabel2.setText("Searches:");

        numSearches.setText("30");
        numSearches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numSearchesActionPerformed(evt);
            }
        });

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numSearches))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numSearches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numSearchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numSearchesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numSearchesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int num = Integer.parseInt(numSearches.getText());
        Desktop d = Desktop.getDesktop();
        timer = new Timer();

        
        if(running == true)
        {
            task.cancel();
            running = false;
            jButton1.setText("Start");
            return;
        }
        
        task = new TimerTask(){
            
            public void run(){
                if(count < num)
                {
                    try {
                        running = true;
                        jButton1.setText("Stop");
                        //for (int i = 0; i < num; i++)
                        d.browse(new URI("https://bing.com/search?q=" + (char)(int)(Math.random() * 26 + 97)
                                + (char)(int)(Math.random() * 26 + 97) + (char)(int)(Math.random() * 26 + 97)));
                    count++;
                    }
                    catch (IOException | URISyntaxException e) {
                    }
                } else {
                    timer.cancel();
                    running = false;
                    jButton1.setText("Start");
                }
            }
        };
            timer.schedule(task,0,1000);
            count = 0;
            
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /*
   public static void openWebpage(String urlString) {
    try {
        Desktop.getDesktop().browse(new URL(urlString).toURI());
    } catch (Exception e) {
        e.printStackTrace();
    }
} */
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BingBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BingBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BingBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BingBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BingBot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField numSearches;
    // End of variables declaration//GEN-END:variables
}
