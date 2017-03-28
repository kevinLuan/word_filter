
###敏感词过滤系统

###author:kevin Luan
	email: kevin_Luan@126.com

### 打包成JAR 包命令

	安装包本地仓库
	mvn clean compile install -Dmaven.test.skip=true

###Running the samples

	String[] keywords =new String[] { "奸","强奸", "性感", "性欲", "性爱", "欲望", "激情", "狂", "联系", "色诱", "评", "骚"};
	//初始化敏感词数据结构
	TreeNode root= TreeNode.markNode(keywords);
	//敏感词过滤器
    WordFilter filterService = new WordFilter(root);
    //解析存在的敏感词token
	LinkedList<WordParser.WordToken> list= filterService.parser(str);
    for(WordParser.WordToken token:list){
       System.out.println(token);
    }
	//过滤敏感词处理
    WordFilter filterService = new WordFilter(root);
    System.out.println(filterService.filter(str));


###Importing into eclipse
	
	mvn eclipse:eclipse
	
####问题反馈 
    
    to mail: kevin_Luan@126.com
    

