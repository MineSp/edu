import axios from 'axios'


/**
 * 取得信息列表
 * @param currentPage
 */
//  function getMsgTable(currentPage) {
//     axios.get("http://localhost:8086/msg/findAll/" + (currentPage - 1) + "/1").then(res => {

//         console.log(res)
//         return res;

//     }).catch(function (error) {
//         console.log(error)
//     })
// }


export { getMsgTable }