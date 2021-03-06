var fs = require('fs');
 
var obj = {
 
    getFileDb: function () {
        return  __dirname + '../../../json/materialAdd.json';
    },
 
    getData: function () {
        var db = this.getFileDb();
        var fileContent = fs.readFileSync(db, 'utf8');
        var fileJson = [];
        if (fileContent) {
            fileJson = JSON.parse(fileContent);
        }
        return fileJson;
    },
 
    saveData: function (fileJson) {
        var db = this.getFileDb();
        var data = JSON.stringify(fileJson);
        fs.writeFileSync(db, data, 'utf8');
        return data;
    }
 
};
 
module.exports = obj;