app.controller('brandController',function ($scope,brandService) {

    $scope.paginationConf ={
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };

    //重新加载列表
    $scope.reloadList=function () {
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    $scope.findAll=function (){
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }

    $scope.findPage=function (page,rows) {
        brandService.findPage(page,rows,$scope).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    $scope.save=function (){
        var object=null;
        if($scope.entity.id!=null){
            object=brandService.update($scope.entity);
        }else{
            object=brandService.add($scope.entity);
        }
        object.success(
            function (response) {
                if(response.success){
                    $scope.reloadList();
                }else{
                    alert(response.message);
                }
            }
        );
    }

    $scope.selectById = function (id) {
        brandService.selectById(id).success(
            function (response){
                $scope.entity=response;

            }
        );
    }

    $scope.selectIds=[];
    $scope.updateSelection = function ($event,id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.selectIds.push(id);
        }else{
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除
        }
    }
    $scope.delete=function () {
        brandService.delete($scope.selectIds).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    $scope.searchEntity={};
    $scope.search=function () {
        brandService.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,$scope.searchEntity).success(
            function (response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
});