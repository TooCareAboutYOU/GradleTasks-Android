生成apks文件
java -jar [ bundletool 文件] build-apks --bundle [ aab 文件] --output [ apks 文件] --ks=[签名文件] --ks-pass=[签名密码] --ks-key-alias=[别名] --key-pass=[别名密码]


java -jar bundletool-all-1.15.4.jar build-apks --bundle /Users/zhangshuai/Project____/Android/GradleTasks-Android/app/build/outputs/bundle/release/app-release.aab --output /Users/zhangshuai/Project____/Android/GradleTasks-Android/aab/aab-app-output.apks --ks=/Users/zhangshuai/Project____/Android/GradleTasks-Android/gradle-taks.jks --ks-pass=zxcvbnm --ks-key-alias=zxcvbnm --key-pass=zxcvbnm

安装apks
java -jar [ bundletool 文件] install-apks --apks [ apks 文件]

java -jar bundletool-all-1.15.4.jar install-apks --apks /Users/zhangshuai/Project____/Android/GradleTasks-Android/aab/aab-app-output.apks
