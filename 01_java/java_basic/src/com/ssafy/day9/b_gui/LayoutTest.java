package com.ssafy.day9.b_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutTest extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel lNum1, lNum2, lCorrectCnt, lWrongCnt;
    private JTextField tfAns;
    private int answer;

    public static void main(String[] args) {
        LayoutTest lt = new LayoutTest();
        lt.launchUi();
    }

    private void launchUi() {
        this.add(new JLabel("구구단을 외자!"), BorderLayout.NORTH);

        makeResultPanel();
        makeProblemPanel();
        // Frame 기본 설정
        this.setTitle("layout test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(300, 150);
        //this.pack(); // 화면에 맞게 크기 자동 설정
        this.setVisible(true);
    }

    private void makeProblem() {
        Random rand = new Random();
        int num1 = rand.nextInt(9) + 1;
        int num2 = rand.nextInt(9) + 1;
        this.answer = num1 * num2;
        lNum1.setText(num1 + "");
        lNum2.setText(num2 + "");
        tfAns.setText("");
    }

    private void makeResultPanel() {
        // TODO: 결과를 보여줄 panel을 구성하시오.
    	// 하단에 보여줄 결과 메세지
    	JPanel panel = new JPanel();
    	panel.add(new JLabel("정답 개수: "));
    
    	lCorrectCnt = new JLabel("0");
    	panel.add(lCorrectCnt);
    	panel.add(new JLabel("오답 개수: "));
    	lWrongCnt = new JLabel("0");
    	panel.add(lWrongCnt);
    	
    	this.add(panel, BorderLayout.SOUTH);
        // END
    }

    // 구구단 문제 판넬 구성
    private void makeProblemPanel() {
        // TODO: 문제를 출제할 패널을 구성하시오.
    	// java.lang.Math.random() : double
    	JPanel panel = new JPanel();
    	lNum1 = new JLabel();
    	lNum2 = new JLabel();
    	// 구구단 결과 입력 위한 component
    	tfAns = new JTextField(10);
    	   
    	// 생성된 구구단 문제 판넬에 구구단 수자, 구구단 입력 위한 component 추가
    	panel.add(lNum1);
    	panel.add(new JLabel(" X "));
    	panel.add(lNum2);
    	panel.add(new JLabel(" = "));
    	// 구구단 결과 입력 텍스트 필드 판넬에 추가
    	panel.add(tfAns);
    	JButton btn = new JButton();
    	btn.add(new JLabel("Button"));
    	
    	btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
   				// tfAns 입력한 구구단 데이터 가져오기
				try {
					int val = Integer.parseInt(tfAns.getText());
					if(val == answer) {
    					// 정답을 맞춘 경우 정답 개수 +1 증가
    					lCorrectCnt.setText(Integer.parseInt(lCorrectCnt.getText()) + 1 + "");					
    				}else {
    					// 오답 개수 +1 증가
    					lWrongCnt.setText(Integer.parseInt(lWrongCnt.getText()) + 1 + "");
    				}
					tfAns.requestFocus();
				}catch(Exception ex) {
					ex.printStackTrace();
				}finally {
					// 새로운 문제 출제
    				makeProblem();
				}

			}
    	});
    	panel.add(btn);
    	
    	tfAns.addKeyListener(new KeyAdapter() {
    		public void keyReleased(KeyEvent e) {
				// 구구단 결과를 입력하고 엔터키를 치면 구구단 정답/오답 체킹
    			if(e.getKeyCode() == KeyEvent.VK_ENTER) { // Enter가 10
    				// tfAns 입력한 구구단 데이터 가져오기
    				int val = Integer.parseInt(tfAns.getText());
    				try {
    					if(val == answer) {
        					// 정답을 맞춘 경우 정답 개수 +1 증가
        					lCorrectCnt.setText(Integer.parseInt(lCorrectCnt.getText()) + 1 + "");					
        				}else {
        					// 오답 개수 +1 증가
        					lWrongCnt.setText(Integer.parseInt(lWrongCnt.getText()) + 1 + "");
        				}
    				}catch(Exception ex) {
    					ex.printStackTrace();
    				}finally {
    					// 새로운 문제 출제
        				makeProblem();
    				}
    			}
			}
    	});
    	
    	// 구구단 문제가 첨부된 판넬을 Frame에 붙이기
    	// 구구단 문제 출제해서 lNum 1, 2에 설정하기
    	makeProblem();
    	
    	this.add(panel, BorderLayout.CENTER);
    	// END
    }

}
