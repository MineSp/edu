import MenuInfo from '../model/MenuInfo'
let MenuInfoData: MenuInfo[] = [{
    title: "系统信息",
    subItems: [{
        title: "信息列表/home",
        path: "/home"
    }]

}, {
    title: "评价系统",
    subItems: [{
        title: "教师列表/about",
        path: "/about"
    },{
        title: "课程列表/about",
        path: "/about"
    },{
        title: "班级列表/about",
        path: "/about"
    }]
},{
    title: "个人系统",
    subItems: [{
        title: "个人中心/app",
        path: "/app"
    }]
},{
    title: "系统管理",
    subItems: [{
        title: "指标库/test",
        path: "/test"
    },{
        title: "教师列表/test",
        path: "/test"
    },]
}]
export default MenuInfoData;