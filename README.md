#	Blog
blog系统
#	git  init
初始化一个git
# vim .gitignore 
新增以及编写这个文件'node_modules/'意思就是上传的时候忽略这个文件夹以及里面的内容，因为我上传的是nodejs项目文件，所以不用把node_modules上传上去
# git add .    
添加代码到git
# git commit -m '第一个版本'
版本的备注信息
# git remote add origin git@github.com:752337625/Blog.git
当我们从github上直接拷贝仓库的时候不需要使用这一步绑定git仓库,反之将代码关联到github上面，后面的url就是第二部拷贝下来的那个路径
# git push -u origin master
将代码推送上去
#	git clone git@github.com:752337625/Blog.git
克隆github仓库,之后npn install 下载package.json里面的包
