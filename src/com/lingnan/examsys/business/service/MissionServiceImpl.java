package com.lingnan.examsys.business.service;

import java.sql.Connection;

import com.lingnan.examsys.business.dao.MissionDao;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;



public class MissionServiceImpl implements MissionService {
	
	//测试用指示常量：输出程序执行到的类名
		private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
		
		/**
		 * 用户Service类唯一实例(饿汉式)
		 */
		private static MissionService missionService = new MissionServiceImpl();
		
		/**
		 * 获取唯一的Service实例
		 * @return Service实例
		 */
		public static MissionService getInstance() {
			return missionService;
		}

	@Override
	public boolean insertMission(int exam_id, int user_id) {
		boolean flag = false;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			MissionDao missiondao = (MissionDao)DaoFactory.getDao(conn, EnumType.MISSION_DAO);
			flag = missiondao.insertMission(exam_id, user_id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.添加试卷任务表失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return flag;
	}

}
