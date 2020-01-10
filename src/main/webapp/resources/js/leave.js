/**
 * 
 */

$(document).ready(function(){
        
        var HOLIDAYS = [new Date(2020,1-1,1).getTime(), 
        	new Date(2020,1-1,15).getTime(),new Date(2020,3-1,25).getTime(),new Date(2020,5-1,1).getTime(),
        	new Date(2020,6-1,2).getTime(), new Date(2020,10-1,26).getTime()];
        
        
        $.datepicker.setDefaults({beforeShowDay: function(date) {
            if ($.inArray(date.getTime(), HOLIDAYS) > -1) {
                return [false, 'holiday'];
            }
            return $.datepicker.noWeekends(date);
        }});
        
        $('#fromDate').datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            minDate: 0
        });
        $('#toDate').datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
        });
        $('#fromDate').datepicker().bind("change", function () {
            var minValue = $(this).val();
            minValue = $.datepicker.parseDate("yy-mm-dd", minValue);
            $('#toDate').datepicker("option", "minDate", minValue);
            calculate();
        });
        $('#toDate').datepicker().bind("change", function () {
            var maxValue = $(this).val();
            maxValue = $.datepicker.parseDate("yy-mm-dd", maxValue);
            $('#fromDate').datepicker("option", "maxDate", maxValue);
            calculate();
        });

        function calculate() {
            var d1 = $('#fromDate').datepicker('getDate');
            var d2 = $('#toDate').datepicker('getDate');
            var oneDay = 24*60*60*1000;
            var diff = 0;
            if (d1 && d2) {
              diff = Math.round(Math.abs((d2.getTime() - d1.getTime())/(oneDay)))+1;
              while (d1 <= d2) {
                  if ((d1.getDay() || 7) > 5) { // Sat/Sun
                  	diff--;
                  }
                  else if ($.inArray(d1.getTime(), HOLIDAYS) > -1) {
                  	diff--;
                  }
                  d1.setDate(d1.getDate() + 1);
              }
            } else if(d1 != '') {
            	diff = 1;
            }
            $('.calculated').val(diff);
        }
    
    
});
	
	
               