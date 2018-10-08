package com.sherlock.www.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sherlock.www.common.exception.MemberServiceException;
import com.sherlock.www.entity.Memberspace;
import com.sherlock.www.service.IMemberService;

@Controller
public class SpaceController {
	
	@Autowired
	IMemberService member;
	/**
	 * 判断空间是否存在
	 * @return
	 * @throws MemberServiceException 
	 */
	@RequestMapping("judgeSpace1.action")
	public String judgeSpace(Model model,@RequestParam(value="nickname",required=false)String nickname) throws MemberServiceException{
		System.out.println("进入方法：" + nickname);
		long id = member.selectIdByName(nickname);
		model.addAttribute("nickname", nickname);
		if(member.isMemberspace(nickname)==true){
			Memberspace memberspace = member.findSpace(id);
			model.addAttribute("memberspace", memberspace);
			return "member/space";
		}else{
			return "member/noSpace";
		}
	}
	
	@RequestMapping("judgeSpace2.action")
	public String judgeSpace_friend(Model model,@RequestParam(value="friendname",required=false)String friendname) throws MemberServiceException{
		System.out.println("进入方法：" + friendname);
		long id = member.selectIdByName(friendname);
		model.addAttribute("nickname", friendname);
		if(member.isMemberspace(friendname)==true){
			Memberspace memberspace = member.findSpace(id);
			model.addAttribute("memberspace", memberspace);
			return "member/space";
		}else{
			return "hello";
		}
	}
	
	@RequestMapping("createSpace1.action")
	public String createSpace_a(Model model,@RequestParam("nickname")String nickname){
		model.addAttribute("nickname", nickname);
		return "member/createSpace";
	}
	
	@RequestMapping("createSpace2.action")
	public String createSpace_b(HttpServletRequest request,Model model,@RequestParam("nickname")String nickname,
											@RequestParam("opinion")String opinion,
											@RequestParam("runtime")String runtime,
											@RequestParam("runhabit")String runhabit,
											@RequestParam("runstar")String runstar,
											@RequestParam("cellphone")String cellphone,
											@RequestParam("runplace")String runplace,
											@RequestParam("icon")MultipartFile  file
											) throws MemberServiceException{
		System.out.println("创建个人空间");
		if(file != null){
			saveFile(request,file);
		}
		String filePath = request.getServletContext().getRealPath("/") + "upload/"
				+ file.getOriginalFilename();
		long id = member.selectIdByName(nickname);
		Memberspace space = new Memberspace();
		space.setId(id);
		space.setCellphone(cellphone);
		space.setIcon(file.getName());
		space.setOpinion(opinion);
		space.setRunhabit(runhabit);
		space.setRunplace(runplace);
		space.setRunstar(runstar);
		space.setIcon(filePath);
		space.setRuntime(runtime);
		member.saveorupdateMemberspace(space, null);
		model.addAttribute("nickname", nickname);		
		return "member/createSpace";
	}

	private void saveFile(HttpServletRequest request,MultipartFile file) {
					// 判断文件是否为空
					if (!file.isEmpty()) {
						try {
							//保存的文件路径
							//需要的话可以给文件名上加时间戳
							String filePath = request.getServletContext().getRealPath("/") + "upload/"
									+ file.getOriginalFilename();
							//String filePath = "C:\\Users\\Administrator\\Desktop\\"+System.currentTimeMillis()+file.getOriginalFilename();
							File newFile = new File(filePath);
							//文件所在目录不存在就创建
							if (!newFile.getParentFile().exists()){
								newFile.getParentFile().mkdirs();
							}
							// 转存文件
							file.transferTo(newFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				}
	}
