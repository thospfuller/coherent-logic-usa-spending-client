package com.coherentlogic.usaspending.client.webstart.application;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import net.miginfocom.swing.MigLayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coherentlogic.usaspending.client.core.builders.QueryBuilder;
import com.coherentlogic.usaspending.client.core.factories.QueryBuilderFactory;
import com.jamonapi.MonKey;
import com.jamonapi.MonKeyImp;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

/**
 * The front-end for the FRED Client that allows users to directly work with the
 * {@link com.coherentlogic.fred.client.core.builders.QueryBuilder}. 
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
public class USASpendingClientGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final Logger log =
        LoggerFactory.getLogger(USASpendingClientGUI.class);

    private static final String
        BASIC = "Basic",
        MEDIUM = "Medium",
        SUMMARY = "Summary",
        COMPLETE = "Complete",
        USA_SPENDING_CLIENT_GUI = "usaSpendingClientGUI";

    private static final String
        BASIC_QUERY_BUILDER_FACTORY = "basicQueryBuilderFactory",
        MEDIUM_QUERY_BUILDER_FACTORY = "mediumQueryBuilderFactory",
        SUMMARY_QUERY_BUILDER_FACTORY = "summaryQueryBuilderFactory",
        COMPLETE_QUERY_BUILDER_FACTORY = "completeQueryBuilderFactory";

    private static final Map<String, String> beanIdMap =
        new HashMap<String, String> ();

    static {
        beanIdMap.put(BASIC, BASIC_QUERY_BUILDER_FACTORY);
        beanIdMap.put(MEDIUM, MEDIUM_QUERY_BUILDER_FACTORY);
        beanIdMap.put(SUMMARY, SUMMARY_QUERY_BUILDER_FACTORY);
        beanIdMap.put(COMPLETE, COMPLETE_QUERY_BUILDER_FACTORY);
    }

    private static final String
        WRAP = "wrap",
        QUERY_BUILDER = "queryBuilder";

    private final JTextArea outputTextArea = new JTextArea();

    private final JButton runScriptButton = new JButton("Run script");

    private final ButtonGroup requestMenuItemsGroup = new ButtonGroup();

    private final Map<ButtonModel, JRadioButtonMenuItem> radioButtonMap =
        new HashMap<ButtonModel, JRadioButtonMenuItem> ();

    private final GroovyEngine groovyEngine;

    private final Map<String, QueryBuilderFactory> queryBuilderFactoryMap;

    private final Map<String, String> exampleMap;

    private final ObjectStringifier objectStringifier =
        new ObjectStringifier ();

    private final MonKey monKey = new MonKeyImp(
        "Call USASpending.gov web services and return an instance of a " +
        "domain class.", TimeUnit.MILLISECONDS.toString());

    /**
     * @todo Remove the init method from the constructor.
     */
    public USASpendingClientGUI(
        GroovyEngine groovyEngine,
        Map<String, QueryBuilderFactory> queryBuilderFactoryMap,
        Map<String, String> exampleMap
    ) {
        this.groovyEngine = groovyEngine;
        this.queryBuilderFactoryMap = queryBuilderFactoryMap;
        this.exampleMap = exampleMap;

        setTitle("USA Spending Client GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialize ();
    }

    /**
     * @see #initialize()
     */
    void initializeMenu (JTextArea inputTextArea) {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnRequest = new JMenu("Examples");
        menuBar.add(mnRequest);

        JRadioButtonMenuItem basic = new JRadioButtonMenuItem(BASIC);
        mnRequest.add(basic);

        basic.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem medium =
            new JRadioButtonMenuItem(MEDIUM);
        mnRequest.add(medium);

        medium.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem summary =
            new JRadioButtonMenuItem(SUMMARY);
        summary.setSelected(true);
        mnRequest.add(summary);

        summary.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        JRadioButtonMenuItem complete = new JRadioButtonMenuItem(COMPLETE);
        mnRequest.add(complete);

        complete.addActionListener(
            new MenuItemSelectedActionListener (exampleMap, inputTextArea));

        requestMenuItemsGroup.add(basic);
        requestMenuItemsGroup.add(medium);
        requestMenuItemsGroup.add(summary);
        requestMenuItemsGroup.add(complete);

        radioButtonMap.put(basic.getModel(), basic);
        radioButtonMap.put(medium.getModel(), medium);
        radioButtonMap.put(summary.getModel(), summary);
        radioButtonMap.put(complete.getModel(), complete);
    }

    /**
     * Method configures the Swing components that are added to this object's
     * JFrame.
     */
    public void initialize () {

        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        setExtendedState(Frame.MAXIMIZED_BOTH); 
        panel.setLayout(new MigLayout());

        JLabel enterYourQueryLabel = new JLabel(
            "Enter your query here (context contains references to: " +
            "requestBuilder):");

        panel.add(enterYourQueryLabel, WRAP);

        final JTextArea inputTextArea = new JTextArea();

        JScrollPane inputTextAreaScrollPane = new JScrollPane(inputTextArea);

        inputTextAreaScrollPane.
            setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        initializeMenu(inputTextArea);

        String exampleText = exampleMap.get (SUMMARY);

        inputTextArea.setText(exampleText);

        inputTextArea.setColumns(80);
        inputTextArea.setRows(40);
        panel.add(inputTextAreaScrollPane, WRAP);

        panel.add(runScriptButton, WRAP);

        JLabel outputAppearsBelowLabel = new JLabel(
            "The output appears below:");

        panel.add(outputAppearsBelowLabel, WRAP);

        outputTextArea.setColumns(80);
        outputTextArea.setRows(40);

        JScrollPane outputTextAreaScrollPane = new JScrollPane(outputTextArea);

        outputTextAreaScrollPane.
            setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(outputTextAreaScrollPane, WRAP);

        GraphicsEnvironment env =
            GraphicsEnvironment.getLocalGraphicsEnvironment();

        Rectangle bounds = env.getMaximumWindowBounds();

        setBounds(bounds);

        runScriptButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    String scriptText = inputTextArea.getText();

                    log.info("scriptText:\n\n" + scriptText);

                    ButtonModel buttonModel =
                        requestMenuItemsGroup.getSelection();

                    JRadioButtonMenuItem selectedMenuItem =
                        radioButtonMap.get(buttonModel);

                    String selectedText = selectedMenuItem.getText();

                    QueryBuilderFactory queryBuilderFactory =
                        (QueryBuilderFactory)
                            queryBuilderFactoryMap.get(selectedText);

                     QueryBuilder queryBuilder =
                        queryBuilderFactory.getInstance();

                    groovyEngine.setVariable(QUERY_BUILDER, queryBuilder);

                    Object result = null;

                    Monitor monitor = MonitorFactory.start(monKey);

                    try {
                        result = groovyEngine.evaluate(scriptText);
                    } catch (Throwable throwable) {

                        log.error("Evaluation failed for the script:\n\n" +
                            scriptText, throwable);

                        JOptionPane.showMessageDialog(
                            panel,
                            throwable.getMessage(),
                            "Evaluation failed!",
                            JOptionPane.ERROR_MESSAGE);

                        return;
                    } finally {
                        monitor.stop();
                        log.info ("JAMon report: " + monitor);
                    }

                    //log.info("result: " + result);

                    if (result != null) {
                        String stringifiedResult =
                            objectStringifier.toString(result);

                        String fullResult =
                            "// Note that null values are not indicative of " +
                            "a problem, per se, for \n" +
                            "// example the PrimaryKey is only ever assigned " +
                            "when the object has been \n" +
                            "// saved to a database and since this does not " +
                            "happen in this example.\n\n\n" +
                            stringifiedResult;

                        outputTextArea.setText(fullResult);
                    }
                }
            }
        );
    }

    /**
     * The main method uses the Spring application context to get an instance of
     * {@link USASpendingClientGUI} and then displays this object.
     */
    public static void main (String[] unused) throws IOException {

        ApplicationContext applicationContext
            = new ClassPathXmlApplicationContext (
                "application-context.xml");

        USASpendingClientGUI applet = (USASpendingClientGUI)
            applicationContext.getBean(USA_SPENDING_CLIENT_GUI);

        applet.setVisible(true);
    }
}

/**
 * An {@link java.awt.event ActionListener} implementation that adds a given
 * example to the inputTextArea when the user selects a given
 * {@link javax.swing.JMenuItem}.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
class MenuItemSelectedActionListener implements ActionListener {

    private final Map<String, String> exampleMap;

    private final JTextArea inputTextArea;

    public MenuItemSelectedActionListener(
        Map<String, String> exampleMap,
        JTextArea inputTextArea
    ) {
        super();
        this.exampleMap = exampleMap;
        this.inputTextArea = inputTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        JMenuItem menuItem = (JMenuItem) actionEvent.getSource();

        String selectedMenu = menuItem.getText();

        String example = exampleMap.get(selectedMenu);

        inputTextArea.setText(example);
    }
}
