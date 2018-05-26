app.service("uploadService",function ($http) {
    
    //上传文件方法
    this.uploadFile=function () {
        var formData = new FormData();
        formData.append('file',file.files[0]);
        return $http({
            method:'POST',
            url:"../upload.do",
            data: formData,
             /*上传文件需要指定‘Content-Type’: undefined，
             这样浏览器会帮我们把Content-Type 设置为 multipart/form-data.*/
            headers: {'Content-Type':undefined},
            /*通过设置 transformRequest: angular.identity ，
             anjularjs transformRequest function 将序列化我们的formdata object.*/
            transformRequest: angular.identity
        });
    }
});