app.service("brandService",function ($http) {

    this.findAll=function () {
        return $http.get('../brand/findAll.do');
    }

    this.findPage=function (page,rows) {
        return $http.get('../brand/findPage.do?page='+page+'&rows='+rows);
    }

    this.add=function (entity) {
        return $http.post('../brand/add.do',entity);
    }
    this.update=function (entity) {
        return $http.post('../brand/update.do',entity);
    }
    this.delete=function (ids) {
        return $http.get('../brand/delete.do?ids='+ids);
    }
    this.selectById=function (id) {
        return $http.get('../brand/selectOneById.do?id='+id);
    }
    this.search=function (page,rows,serachEntity) {
        return $http.post('../brand/search.do?page='+page+'&rows='+rows,serachEntity);
    }
});