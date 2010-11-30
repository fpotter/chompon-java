import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import com.chompon.client.ChomponClient;
import com.chompon.client.CreateUserEmailZipResponse;
import com.chompon.client.GetCouponInfoResponse;
import com.chompon.client.GetDealsResponse;
import com.chompon.client.GetStoreLinksResponse;
import com.chompon.client.GetUserInfoResponse;


public class Main {

    @SuppressWarnings("static-access")
    public static void getDeals(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("sid").withDescription("Store ID").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("did").withDescription("Deal ID").hasArg(true).create());

        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --get-deals", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String did = line.getOptionValue("did");
        String sid = line.getOptionValue("sid");
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetDealsResponse resp = cc.getDeals(sid, did, false);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    @SuppressWarnings("static-access")
    public static void getDealsByZip(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("zip").withDescription("Zip code").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("past").withDescription("Show only past deals").create());

        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --get-deals-by-zip", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String zip = line.getOptionValue("zip");
        Boolean past = Boolean.parseBoolean(line.getOptionValue("past"));
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetDealsResponse resp = cc.getDealsByZip(zip, past);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    @SuppressWarnings("static-access")
    public static void getDealForUser(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("uid").withDescription("User ID").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("did").withDescription("Deal ID").hasArg(true).create());

        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --get-deal-by-user", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String uid = line.getOptionValue("uid");
        String did = line.getOptionValue("did");
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetDealsResponse resp = cc.getDealForUser(uid, did, true);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    @SuppressWarnings("static-access")
    public static void getUserInfo(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("uid").withDescription("User ID").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("email").withDescription("Email Address").hasArg(true).create());

        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --get-user-info", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String uid = line.getOptionValue("uid");
        String email = line.getOptionValue("email");
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetUserInfoResponse resp = cc.getUserInfo(uid, email);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    @SuppressWarnings("static-access")
    public static void getUserFromEmail(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("email").withDescription("Email Address").hasArg(true).isRequired().create());

        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --get-user-from-email", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String email = line.getOptionValue("email");
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetUserInfoResponse resp = cc.getUserFromEmail(email);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    @SuppressWarnings("static-access")
    public static void getCouponInfo(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("uid").withDescription("Filter by User ID").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("did").withDescription("Filter by Deal ID").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("cid").withDescription("Filter by Coupon ID").hasArg(true).create());

        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --get-coupon-info", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String uid = line.getOptionValue("uid");
        String did = line.getOptionValue("did");
        String cid = line.getOptionValue("cid");
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetCouponInfoResponse resp = cc.getCouponInfo(uid, did, cid);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }  

    @SuppressWarnings("static-access")
    public static void createUser(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("fname").withDescription("Fist name").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("lname").withDescription("Last name").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("zip").withDescription("Zip code").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("email").withDescription("Email address").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("password").withDescription("Password (optional)").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("gender").withDescription("Gender (male or female)").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("birthday").withDescription("Birthday (e.g. 9-15-2008)").hasArg(true).create());
        
        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --create-user", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String fname = line.getOptionValue("fname");
        String lname = line.getOptionValue("lname");
        String zip = line.getOptionValue("zip");
        String email = line.getOptionValue("email");
        String password = line.getOptionValue("password");
        String gender = line.getOptionValue("gender");
        String birthday = line.getOptionValue("birthday");
        
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetUserInfoResponse resp = cc.createUser(fname, lname, zip, email, password, gender, birthday);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    @SuppressWarnings("static-access")
    public static void createUserEmailZip(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("zip").withDescription("Zip code").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("email").withDescription("Email address").hasArg(true).isRequired().create());
        
        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --create-user", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String zip = line.getOptionValue("zip");
        String email = line.getOptionValue("email");
        
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            CreateUserEmailZipResponse resp = cc.createUserEmailZip(zip, email);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    @SuppressWarnings("static-access")
    public static void issueCoupons(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("uid").withDescription("User ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("did").withDescription("Deal ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("td").withDescription("Transaction ID (optional)").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("rf").withDescription("Referral ID (optional)").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("count").withDescription("Count (optional, default is 1)").hasArg(true).create());
        
        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --create-user", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String uid = line.getOptionValue("uid");
        String did = line.getOptionValue("did");
        String td = line.getOptionValue("td");
        String rf = line.getOptionValue("rf");
        int count = (line.getOptionValue("count") == null) ? 1 : Integer.parseInt(line.getOptionValue("count")); 
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetCouponInfoResponse resp = cc.issueCoupon(uid, did, td, rf, count);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    @SuppressWarnings("static-access")
    public static void getStoreLinks(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("sid").withDescription("Store ID").hasArg(true).isRequired().create());

        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --create-user", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String sid = line.getOptionValue("sid");
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetStoreLinksResponse resp = cc.getStoreLinks(sid);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }
    
    @SuppressWarnings("static-access")
    public static void refundCoupon(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("cd").withDescription("Coupon ID").hasArg(true).isRequired().create());

        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --create-user", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String cd = line.getOptionValue("cd");
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            GetCouponInfoResponse resp = cc.refundCoupon(cd);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }  
    
    @SuppressWarnings("static-access")
    public static void getDealSEO(String[] args) {
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("pid").withDescription("Chompon Publisher ID").hasArg(true).isRequired().create());
        options.addOption(OptionBuilder.withLongOpt("auth").withDescription("Chompon Auth Key").hasArg(true).isRequired().create());
        
        options.addOption(OptionBuilder.withLongOpt("zip").withDescription("Zip code").hasArg(true).create());
        options.addOption(OptionBuilder.withLongOpt("did").withDescription("Deal ID").hasArg(true).create());

        CommandLine line;
        
        try {
            CommandLineParser parser = new PosixParser();
            line = parser.parse( options, args );
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("chompon.sh --create-user", options );
            return;
        }
        
        String pid = line.getOptionValue("pid");
        String auth = line.getOptionValue("auth");
        
        if (pid == null && auth == null) {
            System.out.println("ERROR: pid and auth must be supplied.");
            return;
        }
        
        String did = line.getOptionValue("did");
        String zip = line.getOptionValue("zip");
        
        try {
            ChomponClient cc = new ChomponClient(pid, auth);
            
            String resp = cc.getDealSEO(did, zip);
            
            System.out.println(resp.toString());
            
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex);
        }
    }  

    /**
     * Process top-level argument (i.e. the action)
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
                
        Options options = new Options();
        
        options.addOption(OptionBuilder.withLongOpt("get-deals").withDescription("Get a list of deals").create());
        options.addOption(OptionBuilder.withLongOpt("get-deals-by-zip").withDescription("Get a list of deals by zip").create());
        options.addOption(OptionBuilder.withLongOpt("get-deal-for-user").withDescription("Get deal info for a specific user").create());
        options.addOption(OptionBuilder.withLongOpt("get-user-info").withDescription("Get user info").create());
        options.addOption(OptionBuilder.withLongOpt("get-user-from-email").withDescription("Get user info by email").create());
        options.addOption(OptionBuilder.withLongOpt("get-coupon-info").withDescription("Get coupon info").create());
        options.addOption(OptionBuilder.withLongOpt("create-user").withDescription("Create user").create());
        options.addOption(OptionBuilder.withLongOpt("issue-coupons").withDescription("Issue coupons").create());
        options.addOption(OptionBuilder.withLongOpt("create-user-email-zip").withDescription("Create user w/ only email and zip").create());
        options.addOption(OptionBuilder.withLongOpt("get-store-links").withDescription("Get redeem and coupon checking links").create());
        options.addOption(OptionBuilder.withLongOpt("refund-coupon").withDescription("Refund coupon").create());
        options.addOption(OptionBuilder.withLongOpt("get-deal-seo").withDescription("Get deal SEO HTML").create());
        
        if (args.length == 0) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "chompon.sh", options );    
        } else {
            try {
                CommandLineParser parser = new PosixParser();
                CommandLine line = parser.parse( options, new String[]{ args[0] } );
                
                String[] remainingArgs = new String[Math.max(0, args.length - 1)];
                
                for (int i = 0; i < remainingArgs.length; i++) {
                    remainingArgs[i] = args[i + 1];
                }

                if (line.hasOption("get-deals")) {
                    getDeals(remainingArgs);
                } else if (line.hasOption("get-deals-by-zip")) {
                    getDealsByZip(remainingArgs);
                } else if (line.hasOption("get-deal-for-user")) {
                    getDealForUser(remainingArgs);
                } else if (line.hasOption("get-user-info")) {
                    getUserInfo(remainingArgs);
                } else if (line.hasOption("get-user-from-email")) {
                    getUserFromEmail(remainingArgs);
                } else if (line.hasOption("get-coupon-info")) {
                    getCouponInfo(remainingArgs);
                } else if (line.hasOption("create-user")) {
                    createUser(remainingArgs);
                } else if (line.hasOption("issue-coupons")) {
                    issueCoupons(remainingArgs);
                } else if (line.hasOption("create-user-email-zip")) {
                    createUserEmailZip(remainingArgs);                    
                } else if (line.hasOption("get-store-links")) {
                    getStoreLinks(remainingArgs);
                } else if (line.hasOption("refund-coupon")) {
                    refundCoupon(remainingArgs);
                } else if (line.hasOption("get-deal-seo")) {
                    getDealSEO(remainingArgs);
                } else {
                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp("admintool.sh", options );
                }
            }
            catch( ParseException exp ) {
                System.err.println( "Unexpected exception:" + exp.getMessage() );
            }
        }
    }
}
