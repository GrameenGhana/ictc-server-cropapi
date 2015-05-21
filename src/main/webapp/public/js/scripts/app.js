/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/* global angular, cropschedule */

var app = angular.module('cropschedule',[]);

app.controller('ScheduleController',function($scope){
    
    $scope.crops = [{id:'crop1'}];
    
    $scope.addNewCrop = function(){
        var newCropItem = $scope.crops.length+1;
        $scope.crops.push({'id':'crop'+newCropItem});
        
    };
    
 $scope.removeCrop = function() {
    var lastItem = $scope.crops.length-1;
    $scope.crops.splice(lastItem);
  };
    
    
});

$(function () {
    $("#startdate").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat:'dd/mm/yy'
        
    });
});


$(function () {
    $("#enddate").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat:'dd/mm/yy'
        
    });
});


$(function () {
    $("#validuntil").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat:'dd/mm/yy'
        
    });
});


$(function () {
    $("#schedule").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat:'yy-mm-dd'
        
    });
});





