xdescribe("Docker Host usage:", function(){
    var dockerHost = require('docker-host');
    it('should return a remote IP when using an external (or virtualized) docker host', function(){
        expect(dockerHost('tcp://192.168.99.100:2376').host).toBe('192.168.99.100');
    });
    it('should return localhost when using local docker installation', function(){
        expect(dockerHost('/var/unix/docker/docker.sock').host).toBe('localhost');
    });
    it('should presume localhost when none is given', function(){
        expect(dockerHost('').host).toEqual(jasmine.any(String));
    });
});
