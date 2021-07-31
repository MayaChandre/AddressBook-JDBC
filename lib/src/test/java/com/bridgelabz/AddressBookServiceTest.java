package com.bridgelabz;

import java.util.List;


import org.junit.Assert;
import org.junit.Test;

public class AddressBookServiceTest {

	@Test
    public void givenAddressBookDBWhenRetrivedShouldMatchPersonCount() {
        AddressBookService addressBookService = new AddressBookService();
        List<Person> addressBookDataList = addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
        Assert.assertEquals(3, addressBookDataList.size());
    }

    @Test
    public void givenContactInformationWhenUpdatedShouldSyncWithDB() {
        AddressBookService addressBookService = new AddressBookService();
        @SuppressWarnings("unused")
		List<Person> addressBookDataList = addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
        addressBookService.updateContactNumber("maya", "9028363759");
        boolean result = addressBookService.checkAddressBookInSyncWithDB("maya");
        Assert.assertTrue(result);
    }
	
}
