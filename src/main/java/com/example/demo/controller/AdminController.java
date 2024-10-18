package com.example.demo.controller;

import com.example.demo.Dao.AnswerDao;
import com.example.demo.Dao.ProblemDao;
import com.example.demo.Dto.AnswerDto;
import com.example.demo.Dto.ProblemDto;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private com.example.demo.Service.UserService userService;
    @Autowired
    private com.example.demo.Service.AdminService adminService;
    @Autowired
    private com.example.demo.Service.TagService tagService;
    @Autowired
    private com.example.demo.Service.ProblemService problemService;
    @Autowired
    private com.example.demo.Service.AnswerService answerService;
    @Autowired
    private com.example.demo.Service.JuBaoProblemService juBaoProblemService;
    @Autowired
    private com.example.demo.Service.JuBaoHuiDaService juBaoHuiDaService;
    @Autowired
    AnswerDao answerDao;
    @Autowired
    ProblemDao problemDao;

    /*点击进界面就展示所有用户信息，后台返回一个User列表*/
    @PostMapping("/user")
    public List<User> hello1(){
        return userService.SelectAll();
    }
    /*管理员登录，发给后台admin对象，成功返回1，失败返回0*/
    @CrossOrigin(origins = "*")
    @PostMapping("/adminLogin")
    public int adminLogin(@RequestBody  Admin admin){
        return adminService.AdminLogin(admin);
    }
    /*在展示所用用户信息的界面上方做一个搜索条，输入用户名，发送给后台一个name即可，返回用户信息User对象*/
    @PostMapping("/SelectUserByName/{name}")
    public User SelectUserByName(@PathVariable String name){
        return userService.SelectByName(name);
    }
    /*在展示所用用户信息的界面内，每一条用户信息上有一个禁用按钮,点击发送给后台一个UserName即可，成功返回1，失败返回0*/
    @PostMapping("/DisableUser/{UserName}")
    public int DisableUser(@PathVariable String UserName){
        return userService.DisableUser(UserName);
    }
    /*在展示所用用户信息的界面内，每一条用户信息上有一个解除禁用按钮,点击发送给后台一个UserName即可，成功返回1，失败返回0*/
    @PostMapping("/AbleUser/{UserName}")
    public int AbleUser(@PathVariable String UserName){
        return userService.AbleUser(UserName);
    }
    /*标签展示页面，点击进界面就展示所有标签信息，后台返回一个Tag列表（建议界面不要展示id属性，其他都可以展示,提示Count属性可以被理解为调用量，即话题热度）  标签的意思就是每寻找或发布问题时可以选择发布一个或者多个相关标签（美术，体育，人工智能等等）*/
    @PostMapping("/tag")
    public List<com.example.demo.entity.Tag> SelectAllTag(){
        return tagService.SelectAllTag();
    }
    /*标签展示页面，点击进界面就展示所有标签信息，每一个标签后有一个编辑按钮，可以编辑除了id的其他信息，点击编辑按钮后，发送给后台一个被编辑后的Tag对象(要返回全部tag信息，包括id)，后台成功返回1，失败返回0*/
    @PostMapping("/EditTag")
    public int EditTag(@RequestBody com.example.demo.entity.Tag tag){
        return tagService.EditTag(tag);
    }
    /*标签展示页面，点击进界面就展示所有标签信息，每一个标签后有一个删除按钮，点击删除按钮后，发送给后台一个被删除的Tag对象(要返回全部tag信息，包括id)，后台成功返回1，失败返回0*/
    @PostMapping("/DeleteTag")
    public int DeleteTag(@RequestBody com.example.demo.entity.Tag tag){
        return tagService.DeleteTag(tag);
    }
    /*标签展示页面，点击进界面就展示所有标签信息，页面最下方有一个添加按钮，点击添加按钮后，发送给后台一个被添加的Tag对象(要返回全部tag信息，不需要包括id)，后台成功返回1，失败返回0*/
    @PostMapping("/AddTag")
    public int AddTag(@RequestBody com.example.demo.entity.Tag tag){
        return tagService.AddTag(tag);
    }
    /*点击进入问题界面，问题界面展示所有问题，后台传给前端一个problem对象列表（建议不展示id属性，其他都可以展示,money属性较为特殊，如果是0则代表不是悬赏问题，其余整数数字即为悬赏金额）*/
    /*problemName字段是该问题的内容*/
    @PostMapping("/problem")
    public List<com.example.demo.entity.Problem> SelectAllProblem(){
        return problemService.SelectAll();
    }
    /*点击点击进入问题界面，问题界面展示所有问题，每一条问题后有一个禁用按钮和解禁按钮，点击禁用按钮后，发送给后台一个禁用的Problem对象(要返回全部problem信息，包括id)，后台成功返回1，失败返回0*/
    @PostMapping("/DisableProblem")
    public int DisableProblem(@RequestBody com.example.demo.entity.Problem problem){
        return problemService.DisableProblem(problem);
    }
    /*点击点击进入问题界面，问题界面展示所有问题，每一条问题后有一个禁用按钮和解禁按钮，点击解禁按钮后，发送给后台一个解禁用的Problem对象(要返回全部problem信息，包括id)，后台成功返回1，失败返回0*/
    @PostMapping("/AbleProblem")
    public int AbleProblem(@RequestBody com.example.demo.entity.Problem problem){
        return problemService.AbleProblem(problem);
    }
    /*点击进入管理界面，进入回答管理界面，进入及展示所有回答，后台传给前端一个answer对象列表（建议不展示id属性）*/
    @PostMapping("/answer")
    public List<Answer> SelectAllAnswer(){
        return answerService.SelectAll();
    }
    /*点击进入管理界面，进入回答管理界面，进入及展示所有回答，每一条回答后有一个禁用按钮和解禁按钮，点击禁用按钮后，发送给后台一个禁用的Answer对象(要返回全部answer信息，包括id)，后台成功返回1，失败返回0*/
    @PostMapping("/DisableAnswer")
    public int DisableAnswer(@RequestBody Answer answer){
        return answerService.DisableAnswer(answer);
    }
    /*点击进入管理界面，进入回答管理界面，进入及展示所有回答，每一条回答后有一个禁用按钮和解禁按钮，点击解禁按钮后，发送给后台一个解禁用的Answer对象(要返回全部answer信息，包括id)，后台成功返回1，失败返回0*/
    @PostMapping("/AbleAnswer")
    public int AbleAnswer(@RequestBody Answer answer){
        return answerService.AbleAnswer(answer);
    }
    /*点击进入举报管理的大标签，标签下有两个小标签，一个是问题举报管理，一个是回答举报管理，点击问题举报标签及展示所有问题举报，后台返回给前台一个举报ProblemDto列表
    * 注意该dto里的Status属性表示该问题是否被封禁需要在后续按钮处展示1正常，0禁用*/
    @PostMapping("/JuBaoWenTi")
    public List<ProblemDto> SelectAllJuBaoProblem(){
        return juBaoProblemService.SelectALL();
    }
    /*点击进入举报管理的大标签，标签下有两个小标签，一个是问题举报管理，一个是回答举报管理，点击回答举报标签及展示所有回答举报，后台返回给前台一个举报JuBaoHuiDa列表
    * 注意该dto里的Status属性表示该回答是否被封禁需要在后续按钮处展示1正常，0禁用*/
    @PostMapping("/JuBaoHuiDa")
    public List<AnswerDto> SelectAllJuBaoHuiDa(){
        return juBaoHuiDaService.SelectALL();
    }
    /*点击进入举报管理的大标签，标签下有两个小标签，一个是问题举报管理，一个是回答举报管理，点击回答举报标签及展示所有回答举报，
    每一条回答举报后均有一个举报按钮和解禁按钮，点击举报按钮后，发送给后台一个AnswerId即可*/
    @PostMapping("/DisAbleJuBaoAnswer/{AnswerId}")
    public int DisAbleJuBaoAnswer(@PathVariable int AnswerId){
        Answer answer=answerDao.SelectById(AnswerId);
        return answerService.DisableAnswer(answer);
    }
    /*点击进入举报管理的大标签，标签下有两个小标签，一个是问题举报管理，一个是回答举报管理，点击回答举报标签及展示所有回答举报，
    每一条回答举报后均有一个举报按钮和解禁按钮，点击解禁按钮后，发送给后台一个AnswerId即可*/
    @PostMapping("/AbleJuBaoAnswer/{AnswerId}")
    public int AbleJuBaoAnswer(@PathVariable int AnswerId){
        Answer answer=answerDao.SelectById(AnswerId);
        return answerService.AbleAnswer(answer);
    }
    /*点击进入举报管理的大标签，标签下有两个小标签，一个是问题举报管理，一个是回答举报管理，点击问题举报标签及展示所有问题举报，
    每一条问题举报后均有一个举报按钮和解禁按钮，点击举报按钮后，发送给后台一个ProblemId即可*/
    @PostMapping("/DisAbleJuBaoProblem/{ProblemId}")
    public int DisAbleJuBaoProblem(@PathVariable int ProblemId){
        Problem problem=problemDao.SelectById(ProblemId);
        return problemService.DisableProblem(problem);
    }
    /*点击进入举报管理的大标签，标签下有两个小标签，一个是问题举报管理，一个是回答举报管理，点击问题举报标签及展示所有问题举报，
    每一条问题举报后均有一个举报按钮和解禁按钮，点击解禁按钮后，发送给后台一个ProblemId即可*/
    @PostMapping("/AbleJuBaoProblem/{ProblemId}")
    public int AbleJuBaoProblem(@PathVariable int ProblemId){
        Problem problem=problemDao.SelectById(ProblemId);
        return problemService.AbleProblem(problem);
    }


}
