package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private ProfilePanel profilePanel = new ProfilePanel();
    private DefinePanel definePanel = new DefinePanel();
    private PlanPanel planPanel = new PlanPanel();
    private CollectPanel collectPanel = new CollectPanel();
    private AnalysePanel analysePanel = new AnalysePanel();
    private StepIndicatorPanel stepIndicator = new StepIndicatorPanel();
    private int currentStep = 0;

    public MainFrame() {
        setTitle("ISO 15939 Simulator");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(stepIndicator, BorderLayout.NORTH);

        mainPanel.add(profilePanel, "Step1_Profile");
        mainPanel.add(definePanel, "Step2_Define");
        mainPanel.add(planPanel, "Step3_Plan");
        mainPanel.add(collectPanel, "Step4_Collect");
        mainPanel.add(analysePanel, "Step5_Analyse");

        add(mainPanel, BorderLayout.CENTER);

        JButton btnNext = new JButton("Next →");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnNext);
        add(bottomPanel, BorderLayout.SOUTH);

        btnNext.addActionListener(e -> {
            try {
                if (currentStep == 0 && profilePanel.isDataValid()) {
                    currentStep = 1;
                    cardLayout.show(mainPanel, "Step2_Define");
                } else if (currentStep == 1) {
                    currentStep = 2;
                    planPanel.loadMetrics(definePanel.getSelectedScenario());
                    cardLayout.show(mainPanel, "Step3_Plan");
                } else if (currentStep == 2) {
                    currentStep = 3;
                    collectPanel.generateInputs(definePanel.getSelectedScenario());
                    cardLayout.show(mainPanel, "Step4_Collect");
                } else if (currentStep == 3) {
                    String scenario = definePanel.getSelectedScenario();
                    double v1, v2;
                    if (scenario.contains("Scenario C")) {
                        v1 = collectPanel.getRawValue("loc");
                        v2 = collectPanel.getRawValue("cc");
                    } else {
                        v1 = collectPanel.getRawValue("coverage");
                        v2 = collectPanel.getRawValue("density");
                    }
                    currentStep = 4;
                    analysePanel.calculateResults(v1, v2);
                    cardLayout.show(mainPanel, "Step5_Analyse");
                    btnNext.setText("Finish");
                } else if (currentStep == 4) {
                    System.exit(0);
                }
                stepIndicator.setCurrentStep(currentStep);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Hata: Lütfen değerleri doğru girin!");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}