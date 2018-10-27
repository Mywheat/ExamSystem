package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.lingnan.examsys.business.domain.Ans_RecordVO;
import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.business.domain.StuFinishStatusVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;
import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.business.service.Tstudent_managementService;
import com.lingnan.examsys.business.service.Tstudent_managementServiceImpl;

public class Tstudent_managementSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Tstudent_managementSetvlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");	
		if("showCl".equals(action)){
			resp.sendRedirect(req.getContextPath()+"/teachers/StudentManagement.jsp");
		}else if("showRank".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<RankingVO> Answer_rank = Tstudent_managementService.findStudentAnswerRank(user_id);
			se.setAttribute("Answer_rank",Answer_rank);
			resp.sendRedirect(req.getContextPath()+"/teachers/FindAllStudent.jsp");
			System.out.println("2完成");
		}else if("showStuAns".equals(action)){
			RankingVO user= new RankingVO();
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			String user_name= new String(req.getParameter("user_name").getBytes("ISO-8859-1"),"utf-8");
			System.out.println("页面取值1"+user_id);
			System.out.println("页面取值2"+user_name);
			user.setUser_id(user_id);
			user.setUser_name(user_name);
			HttpSession se = req.getSession();
			
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<Ans_RecordVO> Answer_record = Tstudent_managementService.findStudentAnswerRecord(user);		
			se.setAttribute("Answer_record",Answer_record);
			resp.sendRedirect(req.getContextPath()+"/teachers/QuestionsRecordList.jsp");
		}else if("showStuClass".equals(action)){
			resp.sendRedirect(req.getContextPath()+"/teachers/ClassManagement.jsp");
		}else if("showStuClassL".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(user_id);		
			se.setAttribute("ClassShow",ClassShow);
			resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
		}//添加班级
		else if("insertTeaClass".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			String class_name=new String(req.getParameter("class_name").getBytes("ISO-8859-1"),"utf-8");
			String class_name=req.getParameter("class_name");
			System.out.println("页面取值"+user_id+class_name);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			boolean cl_na =Tstudent_managementService.findClassByClassName(class_name);
			if(cl_na==true){
				boolean cl_id=Tstudent_managementService.findClassByClassid(class_name);
				if(cl_id==true){
					System.out.println("2进入"+user_id+class_name);
					JOptionPane.showMessageDialog(null, "您已经添加过该班级了");
					//显示该老师教的所有班级
					List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(user_id);		
					se.setAttribute("ClassShow",ClassShow);
					resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
				}
				else{
					System.out.println("3进入"+user_id+class_name);
					ClassVO classShow= Tstudent_managementService.findClassIdByClassname(class_name);
					int class_id=classShow.getClass_id();
					Tea_ClassVO tea_class=new Tea_ClassVO();
					System.out.println(class_name+class_id);
					tea_class.setUser_id(user_id);
					tea_class.setClass_id(class_id);
					
					boolean insert = Tstudent_managementService.insertClassByClassName(tea_class);
					if(insert==true){
						JOptionPane.showMessageDialog(null, "添加成功");
						
					//显示该老师教的所有班级
					List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(user_id);		
					se.setAttribute("ClassShow",ClassShow);
					resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
					}
					else{
						JOptionPane.showMessageDialog(null, "添加失败");
						resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
						
					}
					}
			}
			else
			{	
				System.out.println("4进入"+user_id+class_name);
					//在添加班级上面给出该老师还未添加过的班级。
				List<ClassVO> notClassShow = Tstudent_managementService.findNotClassByTeaId(user_id);		
				se.setAttribute("ClassShow",notClassShow);
				JOptionPane.showMessageDialog(null, "该班级不存在，以下是还未添加过的班级", "提示消息",JOptionPane.WARNING_MESSAGE);
				System.out.println("5进入"+user_id+class_name);
				resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
			}
		}//删除班级
		else if("deleteTeaClass".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			int class_id = Integer.parseInt(req.getParameter("class_id"));
			String class_name=new String(req.getParameter("class_name").getBytes("ISO-8859-1"),"utf-8");
			ClassVO  classin=new ClassVO();
			classin.setClass_name(class_name);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			boolean dele = Tstudent_managementService.deleteTeaClass(classin);
			if(dele==true){
				List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(user_id);		
				se.setAttribute("ClassShow",ClassShow);
				resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
			}
			else{
				JOptionPane.showMessageDialog(null, "删除失败");
				//显示该老师教的所有班级
				List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaId(user_id);		
				se.setAttribute("ClassShow",ClassShow);
				resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
			
			}
		}//搜索框搜索班级
		else if("findClass".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
//			int class_id = Integer.parseInt(req.getParameter("class_id"));
			String class_name=req.getParameter("class_name");
//			String class_name=new String(req.getParameter("class_name").getBytes("ISO-8859-1"),"utf-8");
			System.out.println("页面取值："+user_id+class_name);
			
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			List<ClassVO> ClassShow = Tstudent_managementService.findClassByTeaIdAndCn(user_id, class_name);	
			se.setAttribute("ClassShow",ClassShow);
			resp.sendRedirect(req.getContextPath()+"/teachers/Classlist.jsp");
		
		}//查看班级情况
		else if("particulars".equals(action)){
			int user_id =Integer.parseInt(req.getParameter("user_id"));
			int class_id =Integer.parseInt(req.getParameter("class_id"));
			String class_name=new String(req.getParameter("class_name").getBytes("ISO-8859-1"),"utf-8");
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			//统计班级总人数
			int stu_Cnum =Tstudent_managementService.findSTNumberByCn(class_name);
			se.setAttribute("stu_Cnum",stu_Cnum);
			//查找试卷
			List<ExaminationVO> findExamination =Tstudent_managementService.findExamByUid(user_id,class_name);
			se.setAttribute("findExamination",findExamination);
			
			se.setAttribute("class_id",class_id);
			System.out.println("haha2222"+stu_Cnum);
			resp.sendRedirect(req.getContextPath()+"/teachers/ClassCompletion.jsp");
		
		}else if("findStuStatus".equals(action)){
			int exam_id =Integer.parseInt(req.getParameter("exam_id"));
			int class_id =Integer.parseInt(req.getParameter("class_id"));
			int fnum =Integer.parseInt(req.getParameter("fnum"));
			int anum =Integer.parseInt(req.getParameter("anum"));
			System.out.println("hah"+exam_id+"   hhh"+class_id+"  fnum   "+fnum+" anum "+anum);
			HttpSession se = req.getSession();
			// 调用Service方法
			Tstudent_managementService Tstudent_managementService = new Tstudent_managementServiceImpl();
			se.setAttribute("fnum",fnum);//完成人数
			se.setAttribute("anum",anum);//班级总人数
			//查找试卷
			List<StuFinishStatusVO> StuFinishStatus=Tstudent_managementService.findStuStatus(exam_id);
			se.setAttribute("StuFinishStatus",StuFinishStatus);
			resp.sendRedirect(req.getContextPath()+"/teachers/TestCase.jsp");
		
		}
		
		
//			resp.setContentType("/teacher/manage_students.jsp");
	}
}
