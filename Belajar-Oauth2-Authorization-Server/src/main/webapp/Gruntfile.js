'use strict';

module.exports = function(grunt) {

  grunt.initConfig({
    wiredep: {
      task: {
        src: [
          'pages/*.jsp'
        ]
      }
    }
  });

  grunt.loadNpmTasks('grunt-wiredep');
};
