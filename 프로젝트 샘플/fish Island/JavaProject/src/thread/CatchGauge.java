package thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.bind.Marshaller.Listener;

import dao.MemberDao;
import dto.Fish;
import dto.Member;
import gui.FishingGame;

public class CatchGauge extends Thread implements ActionListener{
	JLabel lblFish,lblRod, lblGauge;
	int x,gaugeWidth,y,gaugeHeight;
	boolean flag1,flag2;
	JFrame fishingGame;
	Fish f;
	Member m;
	String fname, id;
	JDialog successDialog,failDialog;
			
	public CatchGauge(Fish f,Member m,JLabel lblFish,JLabel lblRod, JLabel lblGauge, JFrame fishingGame)
	{
		this.f=f;
		this.m=m;
		this.lblFish=lblFish;
		this.lblRod=lblRod;
		this.lblGauge=lblGauge;
		this.fishingGame = fishingGame;
		this.fname = f.getFname();
		id =m.getId(); 
				
		x=lblGauge.getX();
		y=lblGauge.getY();
		gaugeHeight=lblGauge.getHeight();
		gaugeWidth=lblGauge.getWidth();	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Catch Thread");
		try {
			while(true)
			{
				if((lblRod.getY()-5<=lblFish.getY() && lblRod.getY()+lblRod.getHeight()+5>=lblFish.getY()+lblFish.getHeight()))
				{
					up();
				}
				else
					down();
				this.sleep(100);
				
				if(flag1)
				{
					JButton btnSuccess=new JButton("Success");
					
					successDialog=new JDialog();
					successDialog.setTitle(fname+"을 잡았습니다.");
					successDialog.add(btnSuccess);
					successDialog.setSize(300,150);
					successDialog.setVisible(true);
					btnSuccess.addActionListener(this);
					fishingGame.dispose();
					return;
				}else if(flag2)
				{
					JButton btnFail=new JButton("Fail");
					
					failDialog=new JDialog();
					failDialog.setTitle(fname+"을 놓쳤습니다.");
					failDialog.add(btnFail);
					failDialog.setSize(300,150);
					failDialog.setVisible(true);
					btnFail.addActionListener(this);
					fishingGame.dispose();
					return;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}		
	}
	
	synchronized void up()
	{
//		lblGauge.setLocation(x,y-10);
		x=lblGauge.getX();
		y=lblGauge.getY();
		gaugeHeight=lblGauge.getHeight();
		gaugeWidth=lblGauge.getWidth();
		
		if(gaugeHeight<=300) {
			lblGauge.setBounds(x, y-5, gaugeWidth, gaugeHeight+5);
			lblGauge.repaint();
		}else {
			flag1=true;
		}
	}
	
	synchronized void down()
	{
		x=lblGauge.getX();
		y=lblGauge.getY();
		gaugeHeight=lblGauge.getHeight();
		gaugeWidth=lblGauge.getWidth();
		
		if(gaugeHeight>=0) {
			lblGauge.setBounds(x, y+5, gaugeWidth, gaugeHeight-5);
			lblGauge.repaint();
		}else
			flag2=true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str=e.getActionCommand();
		if(str.equals("Success"))
		{
			int n=-1;
			int x =0;
			boolean flag=false;
			MemberDao memberDao=MemberDao.getInstance();
			m = memberDao.selectOne(id);
			n = memberDao.SuccessFishing(m.getF_stack(),id, f.getFno());
			
			
			String dic_=m.getDic();
			if(dic_==null) {
				memberDao.DicFish(dic_, id, f.getFno());
			}else {
			StringTokenizer st = new StringTokenizer(dic_,",");
			
			for(int i=0;i<st.countTokens();i++) {
				int fno_ = Integer.parseInt(st.nextToken());
				
				
				if(f.getFno() == fno_ ) {
					flag=true;
					break;
				}else {
					flag=false;
					
				}
				
			}
			if(flag==false) {
				x=f.getFno();
				memberDao.DicFish(dic_, id, x);
			}		
			
			}
			
			successDialog.dispose();
			x=0;
		}
		else if(str.equals("Fail"))
		{
			failDialog.dispose();
		}
	}
}

