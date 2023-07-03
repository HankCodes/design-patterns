package structural.facade

/**
 * FACADE PATTERN
 * The facade pattern aims to hide complex underlying implementations from the user/client.
 * If a system is complex, it can be beneficial to create a facade to hide the complexity.
 * The facade pattern hides complexity by creating a "wrapper" object that implements a simple interface
 * and delegates the work to the underlying dependencies and objects. By doing this the user/client does not need
 * to know about complex implementations. The user will have a simple interface to work with.
 * By hiding underlying complexity code becomes more readable and easier to maintain.
 *
 * The facade acts as a higher-level interface that makes it easier to use and understand the underlying components.
 *
 * Example of a facade in the Java API is the Collections class. It provides a simple interface to work with
 * collections such as lists, sets and maps. The Collections class is a facade for the underlying implementations
 * of the collections. The user does not need to know anything on how the collections are implemented but can still
 * make use of it.
 *
 *
 * Use Cases
 * - When you want to provide a simple interface to a complex subsystem.
 * - When you need to do major refactoring work to a large monolithic and tightly coupled system.
 * - Hide underlying libraries, frameworks and dependencies making the code easier to update or swap dependencies.
 *
 *
 */
fun main(args: Array<String>) {

    /**
     * ORDERING SYSTEM
     *
     * OPERATIONS
     *  When a user places an order we need to:
     *  - check the stock
     *  - check for a valid payment account
     *  - make a credit check
     *  - register the payment
     *  - register the parcel
     *  - send an email with the parcel ticket and result of payment
     *
     *  When a user wants to refund an order we need to:
     *  - check that the order exists
     *  - check that the order is not already refunded
     *  - check that the order is not already shipped
     *  - check if the order is paid for
     *      - if it is paid, refund the payment
     *      - if it is not paid, cancel the order
     * - send an email with the result of the refund and extra steps if order is shipped.
     *
     * When a user wants to get the order details we need to:
     * - get the order details from the database
     * - get the payment status
     * - get the shipping status
     *
     * ----
     * SYSTEMS
     *  We will use four systems
     *  - Payment system
     *  - Shipping system
     *  - Email system
     *  - Stock system
     *
     *  Payment system functionality
     *  - Check for payment accounts
     *  - Make credit checks
     *  - Register payments
     *  - Refund payments
     *  - Get payment details/status
     *
     *  Shipping system functionality
     *  - Register parcels
     *  - Print parcel tickets
     *  - Get shipping details/status
     *
     *  Email system functionality
     *  - Send emails
     *
     *  Stock system functionality
     *  - Check stock
     *
     *  ----
     * SUMMARY
     * We have a lot of complex systems that needs to work together, and preferably in a correct order.
     * It is a lot to keep track of, and we do not want our users of the ordering system to deal with this complexity.
     * We will create a facade to hide all this complexity and provide a simple interface for the client to use.
     *
     * THE FACADE PATTERN - OrderSystemFacade
     * placeOrder(order) - When a user places an order.
     * getOrderDetails(id) - When a user wants to get the order details.
     * refund() - When a user wants to refund an order.
     *
     */

    println("Facade pattern")
}
