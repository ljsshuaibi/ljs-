package com.example.demo.controller;
import com.example.demo.Dao.*;
import com.example.demo.Dto.JuBaoHuiDaDto;
import com.example.demo.Dto.JuBaoProblemDto;
import com.example.demo.Service.impl.RedisService;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    RedisService redisService;
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
    ProblemDao problemDao;
    @Autowired
    UserDao userDao;
    @Autowired
    AnswerDao answerDao;
    @Autowired
    MoneyDao moneyDao;
    @Autowired
    MingXiDao mingXiDao;
    @Autowired
    TagDao tagDao;
    @Autowired
    private com.example.demo.Service.JuBaoProblemService juBaoProblemService;
    @Autowired
    private com.example.demo.Service.JuBaoHuiDaService juBaoHuiDaService;
    /*用户登录界面，前端返回给我一个User对象，成功登录返回1，因为密码或账号输入错误返回0，被封禁无法登录返回2*/
    @PostMapping("/UserLogin")
    public String UserLogin(@RequestBody User user)
    {
        String Count=redisService.get("TotalPerson");
        int temp=Integer.parseInt(Count);
        redisService.set("TotalPerson",Integer.toString(temp+1));
        User user1= userService.UserLogin(user);
        if(user1==null){
            return "0";
        }
        if(user1!=null && user1.getStatus()==1){
            if(redisService.get(user.getUserName())==null){
                return "no";
            }else{
                String[] split = redisService.get(user.getUserName()).split(" ");
                List<String> list=new ArrayList<>();
                for(String s:split){
                    if (!s.isEmpty()){
                        list.add(s);
                    }
                }
                StringBuilder sb=new StringBuilder();
                for(String s:list){
                    sb.append(s+" ");
                }
                return sb.toString();
            }
        }
        if(user1!=null && user1.getStatus()==0){
            return "fj";
        }
        return "3";
    }
    /*用户界面第一个大标签，知识搜索界面，点击进入后有一个搜索框，在搜索框输入搜索内容，返回所有符合搜索条件的题目Problem列表，如果为空的话需要在
    * 界面打印出“抱歉呢，您所搜所的问题还暂时无人提出，可以尝试去自己提出问题哦”*/
    @PostMapping("/User/Problem/{ProblemName}")
    public List<com.example.demo.entity.Problem> SelectUserProblem(@PathVariable String ProblemName)
    {
        return problemDao.SelectByName(ProblemName);
    }
    /*每一条被搜索展示的问题后应有一个举报按钮，点击举报弹出一个输入框，上面写着举报原因，填写完成后点击发送给后台，前台需要发送一个juBaoProblem对象
    public class JuBaoProblem {
        public String JuBaoUserName; 举报人的name
        public int ProblemId; 问题Id
        public String FaBuUserName; 发布该问题的人的name
        public String Reason; 输入框输入的原因
     }
    后台需要返回一个int，如果返回1，则代表成功，如果返回0，则代表失败，
     */
    @PostMapping("/User/JuBaoProblem")
    public int JuBaoProblem(@RequestBody JuBaoProblem juBaoProblem)
    {
            return juBaoProblemService.AddJuBaoProblem(juBaoProblem);
    }
    /*在完成搜索后，点击下面展示的相关问题，即进入所有有关问题的答案，前提只需要发送给我Problem的id即可，后台成功即返回一个Answer列表，
    如果返回的列表为空，则在界面展示该问题还暂时没有被回答哦*/
    @PostMapping("/User/Answer/{ProblemId}")
    public List<Answer> SelectAnswer(@PathVariable int ProblemId)
    {

        return answerDao.SelectByProblemId(ProblemId);

    }
    /*每一条被搜索展示的回答后应有一个举报按钮，点击举报弹出一个输入框，上面写着举报原因，填写完成后点击发送给后台，前台需要发送一个juBaoHuiDa对象
    public class JuBaoHuiDa {
        public String JuBaoUserName;
        public int AnswerId;
        public String FaBuUserName;
        public String Reason;
    }
    后台需要返回一个int，如果返回1，则代表成功，如果返回0，则代表失败，
     */
    @PostMapping("/User/JuBaoHuiDa")
    public int JuBaoHuiDa(@RequestBody JuBaoHuiDa juBaoHuiDa)
    {
        return juBaoHuiDaService.AddJuBaoHuiDa(juBaoHuiDa);
    }
    /*个人资料展示界面，点击进入后，前台只需要发送一个UserName的路径参数，后台需要返回一个User对象 */
    @PostMapping("/ZZxx/{UserName}")
    public User SelectUser(@PathVariable String UserName)
    {
        return userService.SelectByName(UserName);
    }
    /*在个人界面应该可以看到所有自己发布的问题，点击进入后，前台只需要发送一个UserName的路径参数，后台需要返回一个Problem列表，如果为空，则打印出“您还没有发布过问题哦”*/
    @PostMapping("/User/UserProblem/{UserName}")
    public List<com.example.demo.entity.Problem> SelectUserProblemByName(@PathVariable String UserName)
    {
        return problemService.SelectByUserName(UserName);
    }
    /*在个人界面应该可以看到所有自己发布的回答，点击进入后，前台只需要发送一个UserName的路径参数，后台需要返回一个Answer列表，如果为空，则打印出“您还没有发布过回答哦”*/
    @PostMapping("/User/UserAnswer/{UserName}")
    public List<Answer> SelectUserAnswerByName(@PathVariable String UserName)
    {
        return answerDao.SelectByUserName(UserName);
    }
    /*在个人界面点击自己发布过的问题，可以看到所有该问题的回答，点击进入后，前台只需要发送一个ProblemId的路径参数，后台需要返回一个Answer列表，如果为空，则打印出“该问题还没有人回答哦”*/
    @PostMapping("/User/ProblemAnswer/{ProblemId}")
    public List<Answer> SelectProblemAnswer(@PathVariable int ProblemId)
    {
        return answerDao.SelectByProblemId(ProblemId);
    }
    /*在个人界面自己发布的问题点击进入该回答后，可以对自己问题下所发布的所有回答进行评分，点击后弹出一个输入框，上面写着“请输入您对该回答的评分”，
    填写完成后点击发送给后台，前台需要发送一个Answer对象，后台需要返回一个int，如果返回1，则代表成功，如果返回0，则代表失败*/
    @PostMapping("/EditGrade")
    public int EditAnswerGrade(@RequestBody Answer answer)
    {
        System.out.println(answer);
        return answerService.EditAnswer(answer);
    }

    /*在每个问题上有写回答按钮，点击发送给后台一个Answer对象成功1失败0*/
    @PostMapping("/User/AddAnswer")
    public int InsertAnswer(@RequestBody  Answer answer){
        if(answer==null){
            return 0;
        } else{
            redisService.set("TotalAnswer",Integer.toString(Integer.parseInt(redisService.get("TotalAnswer"))+1));
            answer.setStatus(1);
            answer.setTime(LocalDateTime.now());
            answer.setFatherAnswerId(0);
            return answerService.InsertAnswerByUser(answer);
        }
    }
    /*在每个问题的所有回答评分后，应该有一个结算悬赏按钮，点击后自动将悬赏金额加到评分最高的用户的账户中，前台只需要返回给后台一个ProblemId即可，后台需要返回一个int，如果返回1，则代表成功，如果返回0，则代表失败*/
    @PostMapping("/user/SettleMoney/{Id}")
    public int SettleMoney(@PathVariable int Id)
    {

        List<Answer> answers1=answerDao.SelectMaxGrade(Id);
        if(answers1==null) return 2;
        int maxGrade=0;
        Answer answer=new Answer();
        for(Answer answer1:answers1) {
            if(answer1.getGradle()>maxGrade){
                maxGrade=answer1.getGradle();
                answer=answer1;
            }
        }
        User user=userService.SelectByName(answer.getUserName());
        System.out.println(user);
        Problem problem=problemDao.SelectById(answer.getProblemId());
        Money AnswerMoney=moneyDao.SelectByUserName(user.getUserName());
        Money ProblemMoney=moneyDao.SelectByUserName(problem.getUserName());
        if(answer.getGradle()!=0){
            problemDao.EditMoneyStatus(answer.getProblemId());
            MoneyMingXi Usertemple=new MoneyMingXi();
            Usertemple.setMoney(problem.getMoney());
            Usertemple.setMoneyReason("回答"+problem.getProblemName()+"问题获得悬赏");
            Usertemple.setUserName(user.getUserName());
            LocalDateTime time=LocalDateTime.now();
            Usertemple.setTime(time);
            mingXiDao.InsertMoneyMingXi(Usertemple);
            Usertemple.setMoney(problem.getMoney());
            Usertemple.setMoneyReason("结算"+problem.getProblemName()+"问题扣除");
            Usertemple.setUserName(problem.getUserName());
            Usertemple.setTime(time);
            mingXiDao.InsertMoneyMingXi(Usertemple);
            int a=AnswerMoney.getMoney()+problem.getMoney();
            AnswerMoney.setMoney(a);
            a=ProblemMoney.getMoney()-problem.getMoney();
            ProblemMoney.setMoney(a);
            moneyDao.AddMoney(AnswerMoney);
            moneyDao.SubMoney(ProblemMoney);
            problemDao.EditMoneyStatus(answer.getProblemId());
            return 1;}else
            {
                return 0;
        }
    }
    /*返回Tag下拉列表,发布问题时下拉显示所有标签*/
    @PostMapping("/User/Tag")
    public List<Tag> SelectTag()
    {
        return tagDao.SelectAll();
    }
    /*发布问题，前端给我一个problem对象，成功1，失败0*/
    @PostMapping("/AddProplem")
    public int UserAddProblem(@RequestBody Problem problem)
    {
        problem.setTime(LocalDateTime.now());
        redisService.set("TotalProblem",Integer.toString(Integer.parseInt(redisService.get("TotalProblem"))+1));
        return problemDao.InsertProblem(problem);
    }
    /*前台给我一个提现的金额，路径参数Money，成功1，失败0*/
    @PostMapping("/TiXian")
    public int Update(@RequestBody Money money){
       String UserName=money.getUserName();
        Money money1 = moneyDao.SelectByUserName(UserName);
        if(money1.getMoney()>=money.getMoney())
        {
            MoneyMingXi Usertemple=new MoneyMingXi();
            Usertemple.setMoney(money1.getMoney()-money.getMoney());
            Usertemple.setMoneyReason("提现");
            Usertemple.setUserName(UserName);
            LocalDateTime time=LocalDateTime.now();
            Usertemple.setTime(time);
            mingXiDao.InsertMoneyMingXi(Usertemple);
            moneyDao.SubMoney(money);
            return 1;
        }else{
            MoneyMingXi Usertemple=new MoneyMingXi();
            Usertemple.setMoney(money.getMoney()-money1.getMoney());
            Usertemple.setMoneyReason("充值");
            Usertemple.setUserName(UserName);
            LocalDateTime time=LocalDateTime.now();
            Usertemple.setTime(time);
            mingXiDao.InsertMoneyMingXi(Usertemple);
            moneyDao.AddMoney(money);
            return 1;
        }
    }
    /*展示个人资料钱有多少，前端给一个路经参数，后台返回money对象*/
    @PostMapping("/ZhanShi/{UserName}")
    public Money SelectMoney(@PathVariable String UserName)
    {
        return moneyDao.SelectByUserName(UserName);
    }
    /*根据标签查询，前端给我一个标签，返回一个List<Problem>*/
    @PostMapping("/User/STag/{Tag}")
    public List<com.example.demo.entity.Problem> SelectUserProblemTag(@PathVariable String Tag)
    {
        Tag tag=tagDao.SelectByName(Tag);
        tag.setCount(tag.getCount()+1);
        tagDao.EditTag(tag);
        return problemDao.SelectProblemByTag(Tag);
    }
    /*随机返回一个problem列表*/
    @PostMapping("/RandomUser")
    public List<Problem> Random(){
        return problemDao.SelectAll();
    }

    /*个人界面明细，前端给一个AnswerName，返回一个List<MoneyMingXi>*/
    @PostMapping("/User/MoneyMingXi/{UserName}")
    public List<MoneyMingXi> SelectMoneyMingXi(@PathVariable String UserName)
    {
        return mingXiDao.SelectByUserName(UserName);
    }
    /*界面注册*/
    @PostMapping("/ZhuCe")
    public int UserRegister(@RequestBody User user)
    {
        Money money=new Money();
        money.setMoney(0);
        money.setUserName(user.getUserName());
        moneyDao.InsertMoney(money);
        return userDao.InsertUser(user);
    }
    /*个人界面个人资料修改*/
    @PostMapping("/Gai")
    public int XiuGai(@RequestBody User user){
        return userDao.XiuGai(user);
    }



    @PostMapping("/test")
    public void test()
    {
        Problem problem1=new Problem();
        problem1.setProblemName("123");
        problem1.setTag("123");
        problem1.setMoney(1);
        problem1.setUserName("123");
        problem1.setStatus(1);
        problem1.setTime(LocalDateTime.now());
        problemDao.InsertProblem(problem1);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前的日期和时间: "+now);

    }

}
