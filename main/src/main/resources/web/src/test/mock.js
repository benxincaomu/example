import Mock from 'mockjs';
const isMock=true;
console.log("isMock="+isMock);
if(isMock){
    Mock.mock("\.\/web\/user\/findUsers","get",()=>{
        let arr=[];
        for(let i=0;i<5;i++){
            let item=Mock.mock({
                "age|1-100":100,
                "id":"@guid",
                "name":"@cname",
                "nickName":"@cname",
                "userName":"@last",
                "sex|0-1":1
            });
            [{"age|1-100":100,"id":"18d7335f264211e78dded8cb8af3a713","name":"管理员11111","nickName":"管理员","sex":1,"userName":"admin"}]
            arr.push(item)
        }
        return arr;
    });
}