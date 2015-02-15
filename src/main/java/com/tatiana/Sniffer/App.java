package com.tatiana.Sniffer;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.JBinding;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.JRegistry;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.packet.RegistryHeaderErrors;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Http;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Http.Request;
import org.jnetpcap.protocol.tcpip.Http.Response;

import com.tatiana.Sniffer.view.Main;


public class App
{
	List<String> stringAllDevs;
	
    public static void main( String[] args ) throws RegistryHeaderErrors
    {
    	Application.launch(Main.class);
    	/*System.out.println(System.getProperty("java.library.path"));
    	
    	final int myId = JRegistry.register(MyPPPoE.class);
    	JRegistry.addBindings(new JBinding[] {
    			new JBinding.DefaultJBinding(Ip4.ID, myId) {
    				private final MyPPPoE my = new MyPPPoE();  
					public boolean isBound(JPacket packet, int offset) {
						return packet.hasHeader(my) && my.nextId() == 0x21;
					}
					public int getSourceId() {
						return getId();
					}
				}
    	});
    	
    	
    	 List<PcapIf> alldevs = new ArrayList<PcapIf>(); 
         
         StringBuilder errbuf = new StringBuilder(); 

         int r = Pcap.findAllDevs(alldevs, errbuf);
         if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
             System.err.printf("Can't read list of devices, error is %s\n",
                     errbuf.toString());
             return;
         }
         
         int i = 0;
         for (PcapIf device: alldevs) {
         	System.out.println("#" + i++ + device.getName() + "  " + device.getDescription());
         }
         
         /*PcapIf device = alldevs.get(2);
         
         
         int snaplen = 64 * 1024; // Capture all packets, no truncation
         int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
         int timeout = 10 * 1000; // 10 seconds in millis
         Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout,
                 errbuf);

         if (pcap == null) {
         	System.out.println("Not open device");
             System.err.println(errbuf); // Error is stored in errbuf if any
             return;
         }
         
         System.out.println("Opened device:" + device.getName());

         PcapPacketHandler<Object> handler = new PcapPacketHandler<Object>() {

         	final Tcp tcp = new Tcp();
         	final Http http = new Http();
         	final Ip4 ip = new Ip4();
         	
             public void nextPacket(PcapPacket packet, Object errbuf) {
                 if (packet.hasHeader(http)) {
                     packet.getHeader(http);
                     final String content_length = http.fieldValue(Response.Content_Length);
                     final String response_code = http.fieldValue(Response.ResponseCode);
                     
                     packet.getHeader(tcp);
                     Integer int_tcp_source = new Integer(tcp.source());
                     Integer int_tcp_destination = new Integer(tcp.destination());
                     if (int_tcp_source != 80 && content_length == null) {
                         packet.getHeader(http);
                         final String ref = http.fieldValue(Request.Referer);
                         String page_url = http.fieldValue(Request.Host);
                         packet.getHeader(ip);
                         System.out.printf("\nHost " + page_url + "  " + http.fieldValue(Request.RequestMethod) + "  " +
                         		tcp.source()+ "  " + ip.size());
                     }
                 }
             }
         };
         pcap.loop(Pcap.LOOP_INFINITE, handler, null);
         
         pcap.close();*/
    }
    
    public ArrayList<String> getListAllDevs() {
    	List<PcapIf> alldevs = new ArrayList<PcapIf>(); 
        
        StringBuilder errbuf = new StringBuilder(); 

        int r = Pcap.findAllDevs(alldevs, errbuf);
        if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
            System.err.printf("Can't read list of devices, error is %s\n",
                    errbuf.toString());
            return null;
        }
        
        int i = 0;
        stringAllDevs = new ArrayList<String>();
        for (PcapIf device: alldevs) {
        	stringAllDevs.add(i, device.getName());
        	System.out.println("#" + i++ + device.getName() + "  " + device.getDescription());
        }
        
        return (ArrayList<String>) stringAllDevs;
    }
}
