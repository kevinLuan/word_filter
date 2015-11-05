#敏感词过滤系统

### author:kevin Luan
	email: kevin_Luan@126.com

### 打包成JAR 包命令
	安装包本地仓库
	mvn clean compile install -Dmaven.test.skip=true

###Running the samples
	String[] keywords =new String[] { "奸","强奸", "性感", "性欲", "性爱", "欲望", "激情", "狂", "联系", "色诱", "评", "骚"};
    	WordFilter filterService = new WordFilter(keywords);
    	System.out.println(filterService.filter(content));

###Importing into eclipse
	mvn eclipse:eclipse
	
