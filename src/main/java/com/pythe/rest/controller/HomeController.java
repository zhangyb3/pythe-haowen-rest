package com.pythe.rest.controller;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.ExceptionUtil;
import com.pythe.pojo.TblSubject;
import com.pythe.rest.service.HomeService;
import com.pythe.rest.service.SubjectService;



@Controller
public class HomeController {

	@Autowired  
    private HomeService service;
	
	@Autowired  
	  private SubjectService subjectService;
	
	
    /**
     * 科目筛选列表
     * @param gradeId
     * @return
     */
    	@RequestMapping(value = "/index/subject", method = RequestMethod.GET)
		@ResponseBody
		public List<TblSubject> selectSubjectByPhase(
				@RequestParam(defaultValue="-1") Integer gradeId){
			return subjectService.selectSubjectByPhase(gradeId);
		}
    
    	
    	
	/**
	 * 首页科目筛选列表
	 * @param gradeId 年级ID
	 * @param subject 科目ID
	 * @return
	 * @throws Exception
	 * 有2种排序方法：按最新时间排（默认），按点赞排
	 *      
	 */
    	@RequestMapping(value = "/index/filterList", method = RequestMethod.GET)
		@ResponseBody
		public PytheResult selectListByGradeIdAndSubject(
				@RequestParam(defaultValue="-1") Integer gradeId,
				@RequestParam("subjectId")Integer subjectId,
				@RequestParam(defaultValue="1") Integer pageNum,
				@RequestParam(defaultValue="10") Integer pageSize) throws Exception{
    	try {
			return PytheResult.ok(service.selectListByGradeIdAndSubject(gradeId,subjectId,pageNum,pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
    }

    
    /**
     * 首页默认列表
     * @param gradeId
     * @return
     * 以后更改：老师为最新更新的。学生为按年级排后再按其他的排
     * 1、先过滤掉打完和超时的数据,先按同年级的时间升序,后合并不同年级的分组数据
     * 更新为：
     * （1）如果是老师或者游客，gradeId=-1
     * （2）如果是学生，先按时间排序，后选择该年级，再后合并其他年级的数据
     */
    @RequestMapping(value = "/index/defaultList", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectDefaultListByGradeId(
			@RequestParam(defaultValue="-1") Integer gradeId,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize){
    	try {
			return PytheResult.ok(service.selectDefaultListByGradeId(gradeId,pageNum,pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
   
    
    /**
     * 首页默认列表第二种形式
     * @param gradeId
     * @return
     * 先过滤掉打完和超时的数据,先按同年级的fee升序，再按likeNum升序,后合并不同年级的分组数据
     * 
     * 改成：按点赞数排哦
     */
    @RequestMapping(value = "/index/defaultList/two", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectTwoDefaultListByGradeId(
			@RequestParam(defaultValue="-1") Integer gradeId,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize){
    	try {
			return service.selectListByFeeAndLikesNum(gradeId,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    

    
    
    
    /**
     * 首页二级列表
     * @param questionId
     * @return 点击一级列表
     */
    @RequestMapping(value = "/index2/question_answers", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectListByQuestionId(@RequestParam("questionId") Long questionId,
			@RequestParam(defaultValue="-1") Long userId
			) {
    	try {

			return service.selectListByQuestionId(questionId,userId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
    /**
     * 
     * 临时搜索功能
     * 默认是按知识点 ，机构，老师，分别表示 0，1，2
     * @param q
     */
    @RequestMapping(value = "/index/search/knowledge", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectKnowledgeOrQuestionContent(@RequestParam("query") String query,
			@RequestParam(defaultValue="-1") Long userId,
			//@RequestParam(required = true, value = "type") Integer type,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize) {
    	try {
    		System.out.println("==========================>" + query);
    		query = URLDecoder.decode(query, "UTF-8");
			return service.selectKnowledgeOrQuestionContent(query,userId,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
    
    @RequestMapping(value = "/index/search/organization", method = RequestMethod.GET)
  	@ResponseBody
  	public PytheResult selectListByOrganization(@RequestParam("query") String query,
  			@RequestParam(defaultValue="-1") Long userId,
  			//@RequestParam(required = true, value = "type") Integer type,
  			@RequestParam(defaultValue="1") Integer pageNum,
  			@RequestParam(defaultValue="10") Integer pageSize) {
      	try {
      		System.out.println("==========================>" + query);
      		query = URLDecoder.decode(query, "UTF-8");
  			return service.selectListByOrganization(query,userId,pageNum,pageSize);
  		} catch (Exception e) {
  			e.printStackTrace();
  			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
  		}
  	}

    
    @RequestMapping(value = "/index/search/teacher", method = RequestMethod.GET)
  	@ResponseBody
  	public PytheResult selectListByTeacher(@RequestParam("query") String query,
  			@RequestParam(defaultValue="-1") Long userId,
  			//@RequestParam(required = true, value = "type") Integer type,
  			@RequestParam(defaultValue="-1") int subjectId,
  			@RequestParam(defaultValue="1") Integer pageNum,
  			@RequestParam(defaultValue="10") Integer pageSize) {
      	try {
      		System.out.println("==========================>" + query);
      		query = URLDecoder.decode(query, "UTF-8");
  			return service.selectListByTeacher(query,userId,subjectId,pageNum,pageSize);
  		} catch (Exception e) {
  			e.printStackTrace();
  			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
  		}
  	}
    
    
   
	
}
